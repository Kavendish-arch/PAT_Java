package com.chen.java_task.demo2;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * JDK自带Timer实现
 * 目前来看，JDK自带的Timer API算是最古老的定时任务实现方式了。Timer是一种定时器工具，用来在一个后台线程计划执行指定任务。它可以安排任务“执行一次”或者定期“执行多次”。
 * <p>
 * 在实际的开发当中，经常需要一些周期性的操作，比如每5分钟执行某一操作等。对于这样的操作最方便、高效的实现方式就是使用java.util.Timer工具类。
 * <p>
 * 核心方法
 * Timer类的核心方法如下：
 * ————————————————
 * Timer类核心方法说明：
 * schedule(TimerTask task, long delay)
 * 在指定延迟（毫秒）后执行任务一次
 * schedule(TimerTask task, Date time)
 * 在指定时间点执行任务一次
 * schedule(TimerTask task, long delay, long period)
 * 固定延迟重复执行：每次执行完成后等待指定周期再执行下一次
 * schedule(TimerTask task, Date firstTime, long period)
 * 从指定时间开始，以固定延迟方式重复执行
 * scheduleAtFixedRate(TimerTask task, long delay, long period)
 * 固定频率重复执行：按照固定频率执行，不受任务执行时间影响
 * scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
 * 从指定时间开始，以固定频率方式重复执行
 * schedule与scheduleAtFixedRate的区别：
 * schedule: 保证任务执行的间隔时间，如果任务执行时间较长，下一次执行时间会相应延后
 * scheduleAtFixedRate: 保证任务执行的频率，即使某次任务执行时间较长，也会尽力保持固定的执行频率
 * 其他重要方法：
 * cancel(): 终止Timer线程，取消所有已安排但尚未执行的任务
 * purge(): 清除已取消的任务，释放相关资源
 * 这个测试演示涵盖了Timer类的所有主要方法及其使用方式。
 */
public class DoSomethingTimerTask extends TimerTask {

    private String taskName;
    private static AtomicInteger counter = new AtomicInteger(0);
    private int taskId;

    public DoSomethingTimerTask(String taskName) {
        this.taskName = taskName;
        this.taskId = counter.incrementAndGet();
    }

    @Override
    public void run() {
        System.out.println(new Date() + " : 任务「" + taskName + " ID:" + taskId + "」被执行。");
    }

    public static void main(String[] args) {
        System.out.println("=== Timer各种方法测试演示 ===");

        // 1. schedule(TimerTask task, long delay) - 延迟执行一次
        testScheduleOnce();

        // 2. schedule(TimerTask task, Date time) - 指定时间执行一次
        testScheduleOnceAtTime();

        // 3. schedule(TimerTask task, long delay, long period) - 延迟执行并固定延迟重复
        testScheduleWithFixedDelay();

        // 4. schedule(TimerTask task, Date firstTime, long period) - 指定时间开始固定延迟重复
        testScheduleWithFixedDelayFromTime();

        // 5. scheduleAtFixedRate(TimerTask task, long delay, long period) - 延迟执行并固定频率重复
        testScheduleAtFixedRate();

        // 6. scheduleAtFixedRate(TimerTask task, Date firstTime, long period) - 指定时间开始固定频率重复
        testScheduleAtFixedRateFromTime();

        // 7. cancel() - 终止Timer
        testTimerCancel();

        // 8. purge() - 清除已取消的任务
        testPurge();
    }

    /**
     * 测试 schedule(TimerTask task, long delay) 方法
     * 在指定延迟后执行任务一次
     */
    private static void testScheduleOnce() {
        System.out.println("\n--- 测试 schedule(TimerTask task, long delay) ---");
        Timer timer = new Timer("ScheduleOnceTimer");
        timer.schedule(new DoSomethingTimerTask("ScheduleOnce"), 1000);

        // 等待任务执行完成
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
    }

    /**
     * 测试 schedule(TimerTask task, Date time) 方法
     * 在指定时间执行任务一次
     */
    private static void testScheduleOnceAtTime() {
        System.out.println("\n--- 测试 schedule(TimerTask task, Date time) ---");
        Timer timer = new Timer("ScheduleOnceAtTimeTimer");
        Date executeTime = new Date(System.currentTimeMillis() + 1000);
        timer.schedule(new DoSomethingTimerTask("ScheduleOnceAtTime"), executeTime);

        // 等待任务执行完成
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
    }

    /**
     * 测试 schedule(TimerTask task, long delay, long period) 方法
     * 固定延迟重复执行任务
     */
    private static void testScheduleWithFixedDelay() {
        System.out.println("\n--- 测试 schedule(TimerTask task, long delay, long period) ---");
        Timer timer = new Timer("ScheduleWithFixedDelayTimer");
        DoSomethingTimerTask task = new DoSomethingTimerTask("ScheduleWithFixedDelay");
        // 延迟1秒后开始，每隔2秒执行一次，执行3次后停止
        timer.schedule(task, 1000, 2000);

        // 等待任务执行几次
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
    }

    /**
     * 测试 schedule(TimerTask task, Date firstTime, long period) 方法
     * 从指定时间开始固定延迟重复执行任务
     */
    private static void testScheduleWithFixedDelayFromTime() {
        System.out.println("\n--- 测试 schedule(TimerTask task, Date firstTime, long period) ---");
        Timer timer = new Timer("ScheduleWithFixedDelayFromTimeTimer");
        DoSomethingTimerTask task = new DoSomethingTimerTask("ScheduleWithFixedDelayFromTime");
        Date startTime = new Date(System.currentTimeMillis() + 1000);
        // 从指定时间开始，每隔1.5秒执行一次，执行3次后停止
        timer.schedule(task, startTime, 1500);

        // 等待任务执行几次
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
    }

    /**
     * 测试 scheduleAtFixedRate(TimerTask task, long delay, long period) 方法
     * 固定频率重复执行任务
     */
    private static void testScheduleAtFixedRate() {
        System.out.println("\n--- 测试 scheduleAtFixedRate(TimerTask task, long delay, long period) ---");
        Timer timer = new Timer("ScheduleAtFixedRateTimer");
        DoSomethingTimerTask task = new DoSomethingTimerTask("ScheduleAtFixedRate");
        // 延迟1秒后开始，每隔2秒执行一次，执行3次后停止
        timer.scheduleAtFixedRate(task, 1000, 2000);

        // 等待任务执行几次
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
    }

    /**
     * 测试 scheduleAtFixedRate(TimerTask task, Date firstTime, long period) 方法
     * 从指定时间开始固定频率重复执行任务
     */
    private static void testScheduleAtFixedRateFromTime() {
        System.out.println("\n--- 测试 scheduleAtFixedRate(TimerTask task, Date firstTime, long period) ---");
        Timer timer = new Timer("ScheduleAtFixedRateFromTimeTimer");
        DoSomethingTimerTask task = new DoSomethingTimerTask("ScheduleAtFixedRateFromTime");
        Date startTime = new Date(System.currentTimeMillis() + 1000);
        // 从指定时间开始，每隔1.5秒执行一次，执行3次后停止
        timer.scheduleAtFixedRate(task, startTime, 1500);

        // 等待任务执行几次
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
    }

    /**
     * 测试 Timer.cancel() 方法
     * 终止Timer线程，取消所有已安排但尚未执行的任务
     */
    private static void testTimerCancel() {
        System.out.println("\n--- 测试 Timer.cancel() ---");
        Timer timer = new Timer("CancelTestTimer");
        DoSomethingTimerTask task = new DoSomethingTimerTask("CancelTest");
        // 安排一个5秒后执行的任务
        timer.schedule(task, 5000);

        // 2秒后取消Timer
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("Timer已取消，5秒后的任务不会执行");
    }

    /**
     * 测试 Timer.purge() 方法
     * 清除已取消的任务，返回被清除的任务数量
     */
    private static void testPurge() {
        System.out.println("\n--- 测试 Timer.purge() ---");
        Timer timer = new Timer("PurgeTestTimer");

        // 创建并安排几个任务
        for (int i = 0; i < 5; i++) {
            DoSomethingTimerTask task = new DoSomethingTimerTask("PurgeTest-" + i);
            timer.schedule(task, 10000); // 10秒后执行
        }

        // 取消所有任务
        timer.cancel();

        // 清除已取消的任务
        int purgedCount = timer.purge();
        System.out.println("清除的任务数量: " + purgedCount);
    }
}
