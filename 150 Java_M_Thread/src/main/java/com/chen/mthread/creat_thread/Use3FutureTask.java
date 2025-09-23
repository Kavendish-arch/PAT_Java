package com.chen.mthread.creat_thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
* @projectName PAT_Java
* @package com.chen.mthread.creat_thread
* @className com.chen.mthread.creat_thread.Use3FutureTask

* @author chenyingtao
* @date 2025/4/20 15:26
* @version 1.0
* @description @todo 
*/
public class Use3FutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("---------------------------");
                System.out.println("FutureTask + Callable Thread 1");
                Thread.sleep(10000);
                return "100";
            }
        });

        Thread t = new Thread(task, "t1");
        t.start();
        // 阻塞
        String result = task.get();
        System.out.println("main " + result);

    }
}
