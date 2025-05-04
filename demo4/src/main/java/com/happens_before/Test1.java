package com.happens_before;

public class Test1 {
    static int x;
    static Object m = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (m) {
                x = 10;
            }
        }, "t1").start();
        new Thread(() -> {
            synchronized (m) {
                System.out.println(x);
            }
        }, "t2").start();
    }
}
