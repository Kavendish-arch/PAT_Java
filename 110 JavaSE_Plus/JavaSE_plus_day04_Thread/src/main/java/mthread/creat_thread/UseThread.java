package mthread.creat_thread;

/**
* @projectName PAT_Java
* @package com.chen.mthread.creat_thread
* @className com.chen.mthread.creat_thread.UseThread

* @author chenyingtao
* @date 2025/4/20 15:11
* @version 1.0
* @description @todo 
*/

//@Slf4j(topic = "c.UserThread")
public class UseThread {
    public static void main(String[] args) {
        Thread t = new Thread(){
            public void run(){
                System.out.println("Thead1 thread is running");
//                log.debug("thread1 is running");
            }
        };
        t.setName("thread1");
        Thread t2 = new Thread(()->{
            System.out.println("Thead2 thread is running");
        });
        t.start();
        t2.setName("thread2");
        t2.start();
        System.out.println("main thread is running");

        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.getState());
        System.out.println(t.isInterrupted());
        System.out.println(t.isAlive());
        System.out.println(t.isDaemon());
        System.out.println(Thread.currentThread());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getState());
        System.out.println(Thread.currentThread().isInterrupted());
    }
}
