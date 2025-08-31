package com.chen.java_task.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Quartz框架实现
 * 除了JDK自带的API之外，我们还可以使用开源的框架来实现，比如Quartz。
 * <p>
 * Quartz是Job scheduling（作业调度）领域的一个开源项目，Quartz既可以单独使用也可以跟spring框架整合使用，在实际开发中一般会使用后者。使用Quartz可以开发一个或者多个定时任务，每个定时任务可以单独指定执行的时间，例如每隔1小时执行一次、每个月第一天上午10点执行一次、每个月最后一天下午5点执行一次等。
 * <p>
 * Quartz通常有三部分组成：调度器（Scheduler）、任务（JobDetail）、触发器（Trigger，包括SimpleTrigger和CronTrigger）。下面以具体的实例进行说明。
 * ————————————————
 * <p>
 * 版权声明：本文为博主原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接和本声明。
 * <p>
 * 原文链接：https://blog.csdn.net/wo541075754/article/details/119405514
 */

public class QuartzTask {


    /**
     * 主函数，用于演示Quartz调度框架的基本使用
     * 该函数创建一个调度器，配置一个定时任务，每隔1秒执行一次，持续1分钟后关闭调度器
     *
     * @param args 命令行参数数组
     * @throws SchedulerException   调度器异常，当调度器初始化或执行过程中出现问题时抛出
     * @throws InterruptedException 中断异常，当线程睡眠过程中被中断时抛出
     */
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
                .withIdentity("job1", "group1").build();

        // 3、构建Trigger实例,每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                .startNow()//立即生效
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)//每隔1s执行一次
                        .repeatForever()).build();//一直执行

        // 4、注册任务和触发器到调度器并启动执行
        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("--------scheduler start ! ------------");
        scheduler.start();

        // 5、让调度器运行1分钟后关闭
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println("--------scheduler shutdown ! ------------");
    }

}
