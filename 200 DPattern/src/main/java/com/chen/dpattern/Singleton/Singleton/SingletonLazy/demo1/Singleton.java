package com.chen.dpattern.Singleton.Singleton.SingletonLazy.demo1;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demoLaste.demo1.Single.SingletonLazy.demo1
 * @className demoLaste.demo1.Single.SingletonLazy.demo1.Simpleton
 * @date 2024/10/22 16:05
 * @description 懒汉模式单例模式
 */
public class Singleton {
    // 2. 私有对象
    private static Singleton instance;

    // 1. 私有构造方法
    private Singleton() {
    }
    // 3. 对外提供访问方法

    /**
     * 线程不安全
     * 需要加同步锁
     *
     * @return demoLaste.demo1.Single.Singleton
     */
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
