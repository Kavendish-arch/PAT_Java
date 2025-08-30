package com.chen.dpattern.Singleton.Singleton.SingletonLazy.demo1;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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
//    public static void main(String[] args) {
//        Singleton instance = Singleton.getInstance();
//        Singleton singleton1 = Singleton.getInstance();
//
//        System.out.println(instance == singleton1);
//    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Client client = new Client();
        client.test2();

        client.test();
    }

    public void test() throws ExecutionException, InterruptedException {
        FutureTask<Singleton> futureTask1 = new FutureTask<>(
                new CallableSingleton()
        );
        FutureTask<Singleton> futureTask2 = new FutureTask<>(
                new CallableSingleton()
        );

        new Thread(futureTask1).start();
        new Thread(futureTask2).start();

        Singleton singleton2 = futureTask1.get();
        Singleton singleton1 = futureTask2.get();

        // 判断是否是同一个对象
        System.out.println("判断是否相同");
        System.out.println(singleton2 == singleton1);
    }

    public void test2() throws ExecutionException, InterruptedException {
        Singleton singleton2 = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        // 判断是否是同一个对象
        System.out.println("判断是否相同");
        System.out.println(singleton2 == singleton1);

    }

}
