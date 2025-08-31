package com.chen.java_task.quartz;

/**
 * Quartz框架实现
 * 除了JDK自带的API之外，我们还可以使用开源的框架来实现，比如Quartz。
 * <p>
 * Quartz是Job scheduling（作业调度）领域的一个开源项目，Quartz既可以单独使用也可以跟spring框架整合使用，在实际开发中一般会使用后者。使用Quartz可以开发一个或者多个定时任务，每个定时任务可以单独指定执行的时间，例如每隔1小时执行一次、每个月第一天上午10点执行一次、每个月最后一天下午5点执行一次等。
 * <p>
 * Quartz通常有三部分组成：调度器（Scheduler）、任务（JobDetail）、触发器（Trigger，包括SimpleTrigger和CronTrigger）。下面以具体的实例进行说明。
 * ————————————————
 */


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 打印单词的Quartz任务类
 * 继承QuartzJobBean以便与Spring Boot集成
 */
@Component
public class PrintWordsJob extends QuartzJobBean {

    /**
     * 执行定时任务的方法
     *
     * @param jobExecutionContext 任务执行上下文，包含任务执行的相关信息
     * @throws JobExecutionException 任务执行异常
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 获取当前时间并格式化为字符串
        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
        // 打印任务开始时间和随机生成的问候语
        System.out.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));
    }
}
