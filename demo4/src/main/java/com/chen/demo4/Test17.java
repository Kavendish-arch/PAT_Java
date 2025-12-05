package com.chen.demo4;

//多线程
public class Test17 {

    static int count = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                count++;
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 10000; i++){
                count++;
            }
        }, "t2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

}
