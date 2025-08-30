package com.chen.dpattern.Singleton.Singleton.ehanmoushi.demo2;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demoLaste.demo1.Single.Singleton.demo1
 * @className demoLaste.demo1.Single.Singleton.demo1.Client
 * @date 2024/10/22 15:15
 * @description 单例模式测试
 */
public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        System.out.println(instance == singleton1);
    }
}
