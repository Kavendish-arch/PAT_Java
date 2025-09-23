package com.chen.java_task.ThreadTask;

/**
 * 创建一个线程，每隔1秒输出Hello
 * @author chen
线程等待实现
先从最原始最简单的方式来讲解。可以先创建一个thread，然后让它在while循环里一直运行着，通过sleep方法来达到定时任务的效果。
 */
public class Task {

    public static void main(String[] args) {
        // run in a second
        final long timeInterval = 1000;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Hello !!");
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
