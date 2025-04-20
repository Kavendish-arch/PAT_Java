package com.chen.demo4;

/**
 * @projectName PAT_Java
 * @package com.chen.demo4
 * @className com.chen.demo4.Test17
 * @author chenyingtao
 * @date 2025/4/20 20:52
 * @version 1.0
 * @description @todo
 */

/**
 * 枷锁
 */
public class Test17Synchronized {
    static int count = 0;
    static final Object lock = new Object();

    /**
     * 如果把 synchronized(obj) 放在 for 循环的外面，如何理解？-- 原子性
     * 如果 t1 synchronized(obj1) 而 t2 synchronized(obj2) 会怎样运作？-- 锁对象
     * 如果 t1 synchronized(obj) 而 t2 没有加会怎么样？如何理解？-- 锁对象
     */
    public static void main(String[] args) {
        test1();
        count = 0;
        test2();
        count = 0;
        test3();
    }

    public static void test1() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
//                    System.out.println(Thread.currentThread().getName() + ": " + count);
                    count++;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
//                    System.out.println(Thread.currentThread().getName() + ": " + count);
                    count++;
                }
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

    public static void test2() {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
//                    System.out.println(Thread.currentThread().getName() + ": " + count);
                    count++;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
//                    System.out.println(Thread.currentThread().getName() + ": " + count);
                    count++;
                }
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

    public static void test3() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++){
                synchronized (lock) {
//                    System.out.println(Thread.currentThread().getName() + ": " + count);
                    count++;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++){
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
