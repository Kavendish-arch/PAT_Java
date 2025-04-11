package com.itheima.scanner;
// 1. 导包： 告诉我们自己的程序，去JDK哪里找Scanner程序用

import java.util.Scanner;

public class ScannerDemo1 {
    public static void main(String[] args) {
        printUserInfo();
    }

    // 需求：我是一个零基础小白，请帮我写一个程序，可以让用户键盘输入用户名和年龄，然后打印出来
    public static void printUserInfo() {
        // 2. 创建对象(抄写这一行代码，得到一个Scanner扫描器对象)
        Scanner sc = new Scanner(System.in);

        // 3. 获取用户输入
        System.out.println("请输入用户名：");
        // 让程序在这一行暂停，等到用户输入一个字符串名称，直到按了回车键之后，把名字交给变量username记住再往下走
        String username = sc.next();
        System.out.println("您叫：" + username);

        System.out.println("请输入年龄：");
        // 让程序在这一行暂停，等到用户输入一个整数，直到按了回车键之后，把年龄交给变量age记住再往下走
        int age = sc.nextInt();
        System.out.println("您多少岁：" + age);
    }
}
