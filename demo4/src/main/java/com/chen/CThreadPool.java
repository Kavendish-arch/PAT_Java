package com.chen;

import javax.management.QueryEval;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.BlockingDeque;

/**
* @projectName PAT_Java
* @package com.chen
* @className com.chen.CThreadPool

* @author chenyingtao
* @date 2025/4/21 14:54
* @version 1.0
* @description @todo 
*/
public class CThreadPool {

    int maxThreadNum = 10;
    private final int maxCoreTaskNum = 10;
    List<Thread> threads = new Vector<>();
//    Queue<Runnable> coreTasks = new BlockingDeque<Runnable>() {};


    public void execute(Runnable task) {
        // 创建线程

        if (threads.size() < maxCoreTaskNum){
            coreTasks.add(task);
        }

        while (true){
        }
//        if (threads.size() >= maxThreadNum) {
//            // 线程池满，等待
//            return;
//        }
//        Thread thread = new Thread(task);
//        threads.add(thread);
//        // 启动线程
////        thread.start();
    }
    //
}
