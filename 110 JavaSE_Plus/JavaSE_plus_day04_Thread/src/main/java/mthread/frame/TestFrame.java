package mthread.frame;

/**
* @projectName PAT_Java
* @package com.chen.mthread.frame
* @className com.chen.mthread.frame.TestFrame

* @author chenyingtao
* @date 2025/4/20 15:51
* @version 1.0
* @description 多线程框架测试类，用于演示基本的线程创建和执行
*/
public class TestFrame {
    /**
     * 程序入口点，创建并启动一个新线程，同时在主线程中执行相同的方法
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 创建一个新线程，该线程将执行test1(10)方法
        Thread t1 = new Thread(()->{
            test1(10);
        });
        t1.setName("thread1");
        t1.start();
        
        // 在主线程中也执行test1(10)方法
        test1(10);
    }

    /**
     * 测试方法1，用于演示基本的变量操作和方法调用
     * @param x 输入的整数值
     */
    public static void test1(int x) {
        int y = x + 1;
        Object m = test2();
        System.out.println(m);
    }

    /**
     * 测试方法2，创建并返回一个新的Object实例
     * @return 新创建的Object对象
     */
    public static Object test2() {
        Object m = new Object();
        return m;
    }
}