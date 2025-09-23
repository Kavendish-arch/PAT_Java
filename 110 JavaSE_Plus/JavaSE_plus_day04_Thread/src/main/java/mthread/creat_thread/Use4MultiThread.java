package mthread.creat_thread;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT_Java
 * @package com.chen.mthread.creat_thread
 * @className com.chen.mthread.creat_thread.Use4MultiThread
 * @date 2025/4/20 15:32
 * @description @todo
 */
public class Use4MultiThread {
    public static void main(String[] args) {
        final int[] x = {0};
        new Thread(() -> {
            while (x[0] < 100) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                x[0]++;
                System.out.println("t1 is running");
            }
        }, "t1").start();
        new Thread(() -> {
            while (x[0] < 100) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                x[0]++;
                System.out.println("t2 is running");

            }
        }, "t2").start();
    }

}
