package com.chen.dpattern.Factory.config_factory;


import com.chen.dpattern.Factory.config_factory.vo.Coffee;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demo1.Factory.FactoryBefore
 * @className demo1.Factory.FactoryBefore.TestCoffeeStore
 * @date 2024/10/22 17:10
 * @description 测试咖啡店类
 */
public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("latte");
        System.out.println(coffee.getName());

        System.out.println("===========================");
        Coffee coffee2 = CoffeeFactory.createCoffee("american");
        System.out.println(coffee2.getName());

    }
}
