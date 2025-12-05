package com.chen.threadSafe;

import com.chen.CThreadPool;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT_Java
 * @package com.chen.threadSafe
 * @className com.chen.threadSafe.Main
 * @date 2025/4/21 14:58
 * @description @todo
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        CThreadPool threadPool = new CThreadPool();
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "执行了");
            }));
        }

        Thread.sleep(1000);
        System.out.println("main线程执行完毕");
    }
}
