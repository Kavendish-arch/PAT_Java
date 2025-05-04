package com.chen.monitor.service;


import com.chen.monitor.controller.MonitorController;
import com.chen.monitor.vo.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yihang
 */
@Service
@Slf4j
public class MonitorService {

    private volatile boolean stop;
    private volatile boolean starting;
    private Thread monitorThread;

    public void start() {
        // 缩小同步范围，提升性能
        synchronized (this) {
            log.info("该监控线程已启动?({})", starting);
            if (starting) {
                return;
            }
            starting = true;
        }

        // 由于之前的 balking 模式，以下代码只可能被一个线程执行，因此无需互斥
        monitorThread = new Thread(() -> {
            while (!stop) {
                report();
                sleep();
            }
            // 这里的监控线程只可能启动一个，因此只需要用 volatile 保证 starting 的可见性
            log.info("监控线程已停止...");
            starting = false;
        });

        stop = false;
        log.info("监控线程已启动...");
        monitorThread.start();
    }

    /**
     * 生成并报告当前系统的内存使用情况
     * 此方法创建一个Info对象来记录当前系统的内存信息，包括总内存、空闲内存和最大内存，
     * 以及当前的时间戳，并将该对象添加到监控队列中
     */
    private void report() {
        // 创建一个新的Info对象来存储内存信息
        Info info = new Info();

        // 设置总内存，即JVM当前从操作系统获得的内存量
        info.setTotal(Runtime.getRuntime().totalMemory());

        // 设置空闲内存，即JVM当前未使用的内存量
        info.setFree(Runtime.getRuntime().freeMemory());

        // 设置最大内存，即JVM可以使用的最大内存量
        info.setMax(Runtime.getRuntime().maxMemory());

        // 设置时间戳，记录当前的系统时间
        info.setTime(System.currentTimeMillis());

        // 将记录了内存信息的Info对象添加到监控队列中
        MonitorController.QUEUE.offer(info);
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ignored) {
        }
    }

    public synchronized void stop() {
        stop = true;
        // 不加打断需要等到下一次 sleep 结束才能退出循环，这里是为了更快结束
        monitorThread.interrupt();
    }

}