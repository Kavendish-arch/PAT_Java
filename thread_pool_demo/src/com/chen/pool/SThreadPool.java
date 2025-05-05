package com.chen.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SThreadPool {

    private final int timeout;
    private final TimeUnit timeUnit;
    private final int coreSize;
    private final int maxSize;
    private RejectHandler rejectHandler;

    BlockingQueue<Runnable> coreQueue = new ArrayBlockingQueue<>(10);

    List<Thread> coreThreads = new ArrayList<>();
    List<Thread> supportThread = new ArrayList<>();

    public SThreadPool(int coreSize, int maxSize, int timeout,
                       TimeUnit timeUnit,
                       RejectHandler rejectHandler) {
        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.timeUnit = timeUnit;
        this.timeout = timeout;
        this.rejectHandler = rejectHandler;

    }


    class CoreThread extends Thread {

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + "从队列中获取任务");
                    Runnable r = coreQueue.take();
                    r.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class SupportThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + "从队列中获取任务");
                    Runnable r = coreQueue.poll(timeout, timeUnit);
                    if (r == null) {
                        break;
                    }
                    r.run();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + "线程结束");
        }

    }
    // Thread thread = new Thread(() -> {

    // }, "唯一的线程");
    // {
    // thread.start();
    // }

    public synchronized void execute(Runnable r) throws RuntimeException {
        // Thread t = new Thread(r);
        // threads.add(t);
        // t.start();
        if (coreThreads.size() < coreSize) {

            Thread t = new CoreThread();
            coreThreads.add(t);
            t.start();
        }

        if (coreQueue.offer(r)) {
            // 任务插入队列中
            return;
        }

        if (coreThreads.size() + supportThread.size() < maxSize) {

            Thread t = new SupportThread();
            supportThread.add(t);
            t.start();

        }
        if (!coreQueue.offer(r)) {
            rejectHandler.reject(r, this);
//            throw new RuntimeException("阻塞队列已满");
        }


    }

    // @todo

    /**
     * 1. 线程池的终止
     * 2. 拒绝策略
     * 3. 线程池的 ThreadFactory 作用
     */
    public void shutdown() {
        // 实现线程池的终止
        ThreadFactory threadFactory;
    }

}
