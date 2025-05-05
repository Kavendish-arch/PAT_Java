package com.chen.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * SimpleThreadPool 类是一个简单的线程池实现，它管理一组线程以执行提交的任务。
 * 线程池旨在通过复用一组固定大小的线程来减少线程创建的开销，并提供任务执行的并发性。
 */
public class SThreadPool {

    // 线程池中线程的最大存活时间
    private final int timeout;
    // 时间单位，用于定义线程的最大存活时间
    private final TimeUnit timeUnit;
    // 核心线程的数量
    private final int coreSize;
    // 线程池中允许的最大线程数
    private final int maxSize;
    // 拒绝策略处理器，当任务无法提交到线程池时执行拒绝策略
    private final RejectHandler rejectHandler;

    private volatile boolean isShutdown = false;

    // 核心任务队列，用于保存待执行的任务
    public BlockingQueue<Runnable> coreQueue = new ArrayBlockingQueue<>(10);

    // 核心线程列表
    List<Thread> coreThreads = new ArrayList<>();
    // 支持线程列表
    List<Thread> supportThread = new ArrayList<>();

    /**
     * 构造一个简单的线程池。
     *
     * @param coreSize      核心线程的数量
     * @param maxSize       线程池中允许的最大线程数
     * @param timeout       线程池中线程的最大存活时间
     * @param timeUnit      时间单位，用于定义线程的最大存活时间
     * @param rejectHandler 拒绝策略处理器，当任务无法提交到线程池时执行拒绝策略
     */
    public SThreadPool(int coreSize, int maxSize, int timeout,
                       TimeUnit timeUnit,
                       RejectHandler rejectHandler) {
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.timeUnit = timeUnit;
        this.timeout = timeout;
        this.rejectHandler = rejectHandler;

    }

    public boolean isShutdown() {

        return isShutdown;
    }

    /**
     * 核心线程类，负责从核心任务队列中取任务并执行。
     */
    class CoreThread extends Thread {

        @Override
        public void run() {
            while (!isShutdown) {
                try {
                    // 核心线程从任务队列中获取任务并执行
                    System.out.println(Thread.currentThread().getName() + "从队列中获取任务");
                    Runnable r = coreQueue.take();
                    r.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 支持线程类，负责在核心线程忙碌时，从核心任务队列中取任务并执行。
     * 支持线程会尝试在指定时间内获取任务，如果失败则终止。
     */
    class SupportThread extends Thread {
        @Override
        public void run() {
            while (!isShutdown) {
                try {
                    // 支持线程尝试在指定时间内从任务队列中获取任务并执行
                    System.out.println(Thread.currentThread().getName() + "从队列中获取任务");
                    Runnable r = coreQueue.poll(timeout, timeUnit);
                    if (r == null) {
                        break;
                    }
                    r.run();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + "线程结束");
        }

    }

    /**
     * 提交一个任务到线程池中执行。
     *
     * @param r 待执行的任务
     * @throws RuntimeException 如果任务提交失败
     */
    public synchronized void execute(Runnable r) throws RuntimeException {
        // 如果核心线程数量未达到核心大小，则创建新的核心线程
        if (coreThreads.size() < coreSize) {

            Thread t = new CoreThread();
            coreThreads.add(t);
            t.start();
        }

        // 尝试将任务放入核心任务队列
        if (coreQueue.offer(r)) {
            // 任务插入队列中
            return;
        }

        // 如果线程池中的线程数量未达到最大允许数量，则创建新的支持线程
        if (coreThreads.size() + supportThread.size() < maxSize) {

            Thread t = new SupportThread();
            supportThread.add(t);
            t.start();

        }
        // 如果任务仍然无法放入核心任务队列，则执行拒绝策略
        if (!coreQueue.offer(r)) {
            rejectHandler.reject(r, this);
//            throw new RuntimeException("阻塞队列已满");
        }
    }

    /**
     * 关闭线程池，释放资源。
     * 1. 停止接受新的任务。
     * 2. 等待正在执行的任务完成。已提交的任务和正在执行的任务
     * 3. 释放线程资源。
     */
    public void shutdown() {
        // 实现线程池的终止
        // 验证是否关闭，防止重复关闭

        if (isShutdown) {
            return;
        }

        isShutdown = true;
        // 中断核心线程
        for (Thread t : coreThreads) {
            if (t != null && t.isAlive()) {
                try {
                    t.join(100);
                } catch (InterruptedException e) {
                    t.interrupt();
                }
            }
        }
        coreThreads.clear();
        // 中断支持线程
        for (Thread t : supportThread) {
            if (t != null && t.isAlive()) {
                try {
                    t.join(100);
                } catch (InterruptedException e) {
                    t.interrupt();
                }
            }
        }
        supportThread.clear();


        coreQueue.clear();

        System.out.println("线程池已关闭");

    }

}
