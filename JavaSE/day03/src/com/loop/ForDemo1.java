package com.loop;

public class ForDemo1 {
    public static void main(String[] args) {
        // 目标：掌握for循环的书写，搞清楚其执行流程。
        test1();
    }

    public static void test1() {
        // 需求：使用for循环，打印3行HelloWorld
        /**
         * 计算机先遇到for知道要开启循环，然后立即执行int i = 0
         * 接着判断循环条件 0 < 3，成立，执行循环体输出第一行HelloWorld，然后执行i++，i = 1
         * 接着判断循环条件 1 < 3，成立，执行循环体输出第二行HelloWorld，然后执行i++，i = 2
         * 接着判断循环条件 2 < 3，成立，执行循环体输出第三行HelloWorld，然后执行i++，i = 3
         * 接着判断循环条件 3 < 3，不成立，循环结束。
         */
        for (int i = 0; i < 3; i++) {
            System.out.println("HelloWorld");
        }
        // System.out.println(i); // 报错

        System.out.println("=======================");

        for (int i = 1; i < 6; i++) {
            // i = 1、2、3、4、5
            System.out.println("HelloWorld");
        }

        System.out.println("=======================");

        for (int i = 1; i <= 9; i+=2) {
            // i = 1 3 5 7 9
            System.out.println("HelloWorld");
        }
    }
}
