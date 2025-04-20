package com.chen.mthread.creat_thread;

/**
* @projectName PAT_Java
* @package com.chen.mthread.creat_thread
* @className com.chen.mthread.creat_thread.UseRunable

* @author chenyingtao
* @date 2025/4/20 15:14
* @version 1.0
* @description @todo 
*/
public class UseRunnable {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("---------------------------");
                System.out.println("Thead1 use runnable ");
                System.out.println("Thead1 thread is running");
                System.out.println("---------------------------");
            }
        };
        Thread t = new Thread(r);
        t.setName("thead1 use runnable fun");
        t.start();


        Runnable r2 = ()->{
            System.out.println("---------------------------");
            System.out.println("Thead2 use runnable ");
            System.out.println("Thead2 thread is running");
            System.out.println("use lambda 方法");
            System.out.println("---------------------------");
        };
        Thread t2 = new Thread(r2);
        t2.setName("thead2 use runnable fun");
        t2.start();

        Thread t3 = new Thread(()->{
            System.out.println("---------------------------");
            System.out.println("Thead3 use runnable ");
            System.out.println("Thead3 thread is running");
            System.out.println("use lambda 方法");
            System.out.println("---------------------------");
        });
        t3.setName("thead3 use runnable fun");
        t3.start();
        System.out.println("main thread is running");
    }
}
