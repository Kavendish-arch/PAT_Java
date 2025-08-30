package com.chen.dpattern.Singleton.Singleton.SingletonLazy.demo2;

import java.io.Serializable;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demoLaste.demo1.Single.SingletonLazy.demo2
 * @className demoLaste.demo1.Single.SingletonLazy.demo2.demoLaste.demo1.Single.Singleton
 * @date 2024/10/22 16:14
 * @description 双重检查锁 单例模式 懒汉式
 */
public class Singleton implements Serializable {
    private static volatile Singleton instance;

    private Singleton()
    {

    }

    public static Singleton getInstance()
    {
        /**
         * 指令重排
         *
         * 多线程情况可能出现空指针
         * 原因：JVM 指令优化和指令重拍
         */
        // 第一次判断， instance == null
        if (instance == null) {
            // 同步代码块
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public Object readResolve(){
        System.out.println("readResolve");
        return Singleton.getInstance();
    }
}
