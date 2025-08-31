package com.chen.java_task.config;

import com.chen.java_task.quartz.PrintWordsJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    /**
     * 创建JobDetail Bean
     *
     * @return JobDetail实例
     */
    @Bean
    public JobDetail printWordsJobDetail() {
        return JobBuilder.newJob(PrintWordsJob.class)
                .withIdentity("printWordsJob")
                .storeDurably()
                .build();
    }

    /**
     * 创建Trigger Bean
     *
     * @return Trigger实例
     */
    @Bean
    public Trigger printWordsJobTrigger() {
        // 每秒执行一次的简单触发器
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
        // 创建一个Cron表达式调度构建器，配置为每5秒执行一次的调度规则
        // Cron表达式 "0/5 * * * * ?" 表示从0秒开始，每隔5秒执行一次
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

        // 创建并返回一个新的触发器构建器实例，用于构建定时任务触发器
        return TriggerBuilder.newTrigger()
                .forJob(printWordsJobDetail())
                .withIdentity("printWordsJobTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
