package com.chen.pool;

import com.chen.pool.impl.DiscardOldestPolicyRejectHandle;

import java.util.concurrent.TimeUnit;

/***
 * 手写线程池
 * 1. 创建线程
 */
public class Main {
    public static void main(String[] args) {
        SThreadPool stp = new SThreadPool(4, 5, 10, TimeUnit.SECONDS,
                new DiscardOldestPolicyRejectHandle());
        for (int i = 0; i < 20; i++) {
            final int i1 = i;
            stp.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("_______ 打印机" + i1 + "在线程上工作" + Thread.currentThread().getName());
            });

        }

        stp.shutdown();

    }
}