package com.chen.dpattern.Singleton.Pohuai.demo1;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demoLaste.demo1.Single.Singleton.demo1
 * @className demoLaste.demo1.Single.Singleton.demo1.demoLaste.demo1.Single.Singleton
 * @date 2024/10/22 13:02
 * @description 单例模式 饿汉式
 */
///创建一个测试类
public class Singleton {

    // 2. 在本类中创建本对象
    private static Singleton instance = new Singleton();

    // 1. 私有构造方法
    private Singleton() {
        System.out.println("创建了Singleton对象");
    }

    // 3. 提供公共访问方法
    public static Singleton getInstance() {
        return instance;
    }
}
