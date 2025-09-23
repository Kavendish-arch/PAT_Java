package com.loop;

public class DeadForDemo7 {
    public static void main(String[] args) {
        // 目标：掌握死循环的写法。
        test();
    }

    public static void test(){
        // 1、for循环实现死循环
//        for ( ; ; ) {
//            System.out.println("Hello World1!");
//        }

        // 2、while循环实现死循环(经典写法)
//        while (true) {
//            System.out.println("Hello World2!");
//        }

        // 3、do...while循环实现死循环
        do {
            System.out.println("Hello World3!");
        }while (true);
    }
}
