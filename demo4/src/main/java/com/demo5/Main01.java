package com.demo5;

public class Main01 {

    // volatile 可以设置可见性
    volatile static boolean run = true;

    //
    final static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (run) {
                // System.out.println("t1");
                // synchronized (lock) {
                    // System.out.println("t1");
                    if (!run) {
                        break;
                    }
                // }
            }
        });
        t1.start();

        Thread.sleep(1);
        System.out.println("主线程停止 t 线程");
        run = false;
    }
}
