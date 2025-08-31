package com.chen.java_task.spring;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component("taskJob")
public class SpringTask {

    /**
     * 定时任务方法，通过cron表达式配置每天凌晨3点执行
     * 该方法无需参数，无返回值
     * 主要功能是输出定时任务执行的提示信息
     */
    @Scheduled(cron = "0 0 3 * * ?")
    public void job1() {
        // 打印定时任务执行信息
        System.out.println("通过cron定义的定时任务");
    }


    /**
     * 定时任务方法，通过fixedDelay属性配置执行间隔
     * 该方法每隔1000毫秒（1秒）执行一次，每次执行完成后等待指定延迟时间再次执行
     * <p>
     * 无参数
     * <p>
     * 无返回值
     */
    @Scheduled(fixedDelay = 1000L)
    public void job2() {
        // 输出定时任务执行信息
        System.out.println("通过fixedDelay定义的定时任务");
    }


    /**
     * 通过fixedRate定义的定时任务
     * 该方法每隔1000毫秒执行一次，用于演示基于固定频率的定时任务调度
     *
     * @Scheduled 注解配置:
     * fixedRate = 1000L 表示任务执行间隔为1000毫秒
     */
    @Scheduled(fixedRate = 1000L)
    public void job3() {
        // 打印定时任务执行信息
        System.out.println("通过fixedRate定义的定时任务");
    }

}
