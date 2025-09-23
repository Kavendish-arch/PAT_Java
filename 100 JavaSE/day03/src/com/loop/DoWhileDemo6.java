package com.loop;

public class DoWhileDemo6 {
    public static void main(String[] args) {
        // 目标：搞清楚do-while循环的写法，并理解其特点。
        test1();
    }

    // 使用do-while循环控制打印三行HelloWorld
    public static void test1() {
        // 特点：先执行后判断（一定会执行一次）。
        int i = 0;
        do {
            System.out.println("HelloWorld");
            i++;
        } while (i < 3);
    }
}
