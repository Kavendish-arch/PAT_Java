package com.chen.mthread.test;

import java.util.concurrent.TimeUnit;

/**
* @projectName PAT_Java
* @package com.chen.mthread.test
* @className com.chen.mthread.test.Test7

* @author chenyingtao
* @date 2025/4/20 16:17
* @version 1.0
* @description @todo 
*/

public class Test7 {
    private static final String THREAD_NAME_T1 = "t1";

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("enter sleep...");
            try {
                TimeUnit.SECONDS.sleep(1);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // 恢复中断状态并规范日志
                Thread.currentThread().interrupt();
                System.out.println("wake up...");
                System.out.println("Sleep interrupted" + e);
            }
        }, THREAD_NAME_T1);

        t1.start();

        Thread.sleep(1000);
        System.out.println("interrupt...");
        t1.interrupt();
    }

}
