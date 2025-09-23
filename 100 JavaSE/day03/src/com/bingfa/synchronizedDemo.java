package com.bingfa;//package com;


public class synchronizedDemo {
    // 原理

    public static void main(String[] args) {
        synchronized (synchronizedDemo.class){
            System.out.println("hello");
        }
    }
}
