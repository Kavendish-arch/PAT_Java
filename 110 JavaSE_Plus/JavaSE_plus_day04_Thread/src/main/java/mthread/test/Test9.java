package mthread.test;

import java.sql.Time;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT_Java
 * @package com.chen.mthread.test
 * @className com.chen.mthread.test.Test9
 * @date 2025/4/20 16:27
 * @description @todo
 */
public class Test9 {
    /**
     * 主函数，用于演示线程优先级对线程执行顺序的影响（实际效果可能因操作系统而异）
     *
     * @param args 命令行参数，本函数未使用该参数
     * @return 无返回值
     */
    public static void main(String[] args) {
        // 定义第一个无限循环任务：持续输出递增计数器（最低优先级线程执行）
        Runnable task1 = () -> {
            int count = 0;
            for (; ; ) {
                System.out.println("---->1 " + count++);
            }
        };

        // 定义第二个无限循环任务：持续输出递增计数器（最高优先级线程执行）
        Runnable task2 = () -> {
            int count = 0;
            for (; ; ) {
//                Thread.yield();
                System.out.println("              ---->2 " + count++);
            }
        };

        /* 线程创建与优先级设置 */
        Thread t1 = new Thread(task1, "t1");
        Thread t2 = new Thread(task2, "t2");
        // 设置线程优先级（MIN=1, MAX=10，效果取决于操作系统调度）
//        t1.setPriority(Thread.MIN_PRIORITY);
//        t2.setPriority(Thread.MAX_PRIORITY);
        long time = System.currentTimeMillis();
        /* 启动两个线程 */
        t1.start();
        t2.start();



    }

}
