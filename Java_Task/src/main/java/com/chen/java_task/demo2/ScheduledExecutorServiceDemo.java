package com.chen.java_task.demo2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ScheduledExecutorService 示例
 * ScheduledExecutorService 是 Java 5 引入的并发工具类，用于替代传统的 Timer。
 * 它基于线程池实现，具有更好的性能和灵活性。
 */
public class ScheduledExecutorServiceDemo {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public static void main(String[] args) {
        System.out.println("=== ScheduledExecutorService 各种方法测试演示 ===\n");

        // 1. schedule(Runnable command, long delay, TimeUnit unit) - 延迟执行一次
        testScheduleOnce();

        // 2. scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) - 固定频率重复执行
        testScheduleAtFixedRate();

        // 3. scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) - 固定延迟重复执行
        testScheduleWithFixedDelay();

        // 4. shutdown() 和 shutdownNow() 方法演示
        testShutdownMethods();
    }

    /**
     * 测试 schedule(Runnable command, long delay, TimeUnit unit) 方法
     * 延迟执行一次任务
     */
    private static void testScheduleOnce() {
        System.out.println("--- 测试 schedule(Runnable, long, TimeUnit) 延迟执行一次 ---");

        // 创建一个单线程的 ScheduledExecutorService
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

        // 创建任务
        Runnable task = () -> {
            System.out.println(dateFormat.format(new Date()) + " : 延迟执行任务被执行");
        };

        // 延迟2秒执行任务
        scheduler.schedule(task, 2, TimeUnit.SECONDS);

        // 等待任务执行完成
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        scheduler.shutdown();
        System.out.println("测试完成\n");
    }

    /**
     * 测试 scheduleAtFixedRate 方法
     * 固定频率重复执行任务
     */
    private static void testScheduleAtFixedRate() {
        System.out.println("--- 测试 scheduleAtFixedRate 固定频率重复执行 ---");

        // 创建一个包含2个线程的 ScheduledExecutorService
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // 计数器，用于控制执行次数
        final int[] counter = {0};
        AtomicInteger atomicInteger = new AtomicInteger(0);
        // 创建任务
        Runnable task = () -> {
//            System.out.println(dateFormat.format(new Date()) + " : 固定频率任务第" + (++counter[0]) + "次执行");
            System.out.println(dateFormat.format(new Date()) + " : 固定频率任务第" +
                    atomicInteger.incrementAndGet() + "次执行");

            // 模拟任务执行时间
            try {
                if (atomicInteger.get() == 2) {
                    // 第二次执行时模拟较长的执行时间
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // 初始延迟1秒，之后每隔2秒执行一次（固定频率）
        scheduler.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        // 运行6秒后停止
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        scheduler.shutdown();
        System.out.println("固定频率任务测试完成\n");
    }

    /**
     * 测试 scheduleWithFixedDelay 方法
     * 固定延迟重复执行任务
     */
    private static void testScheduleWithFixedDelay() {
        System.out.println("--- 测试 scheduleWithFixedDelay 固定延迟重复执行 ---");

        // 创建一个包含2个线程的 ScheduledExecutorService
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // 计数器，用于控制执行次数
        final int[] counter = {0};

        // 创建任务
        Runnable task = () -> {
            System.out.println(dateFormat.format(new Date()) + " : 固定延迟任务第" + (++counter[0]) + "次执行");

            // 模拟任务执行时间
            try {
                if (counter[0] == 2) {
                    // 第二次执行时模拟较长的执行时间
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // 初始延迟1秒，每次执行完成后延迟2秒再执行下一次
        scheduler.scheduleWithFixedDelay(task, 1, 2, TimeUnit.SECONDS);

        // 运行8秒后停止
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        scheduler.shutdown();
        System.out.println("固定延迟任务测试完成\n");
    }

    /**
     * 测试 shutdown() 和 shutdownNow() 方法
     */
    private static void testShutdownMethods() {
        System.out.println("--- 测试 shutdown() 和 shutdownNow() 方法 ---");

        // 创建 ScheduledExecutorService
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // 创建一个长时间运行的任务
        Runnable longRunningTask = () -> {
            System.out.println(dateFormat.format(new Date()) + " : 长时间运行任务开始");
            try {
                // 模拟长时间运行的任务
                Thread.sleep(10000);
                System.out.println(dateFormat.format(new Date()) + " : 长时间运行任务完成");
            } catch (InterruptedException e) {
                System.out.println(dateFormat.format(new Date()) + " : 长时间运行任务被中断");
                Thread.currentThread().interrupt();
            }
        };

        // 创建一个定期执行的任务
        Runnable periodicTask = () -> {
            System.out.println(dateFormat.format(new Date()) + " : 定期任务执行");
        };

        // 安排任务
        scheduler.schedule(longRunningTask, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(periodicTask, 1, 2, TimeUnit.SECONDS);

        // 等待1.5秒确保任务开始执行
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 演示 shutdown() - 等待已提交任务执行完成
        System.out.println(dateFormat.format(new Date()) + " : 调用 shutdown()");
        scheduler.shutdown();

        // 等待一段时间观察效果
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 重新创建 scheduler 进行 shutdownNow() 演示
        scheduler = Executors.newScheduledThreadPool(2);
        scheduler.schedule(longRunningTask, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(periodicTask, 1, 2, TimeUnit.SECONDS);

        // 等待任务开始执行
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 演示 shutdownNow() - 立即尝试停止所有任务
        System.out.println(dateFormat.format(new Date()) + " : 调用 shutdownNow()");
        scheduler.shutdownNow();

        System.out.println("shutdown 测试完成");
    }
}
