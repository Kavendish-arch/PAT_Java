package com.chen.dpattern.Factory.Before;

import com.chen.dpattern.Factory.Before.vo.Coffee;

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
        // 创建咖啡店类
        CoffeeStore coffeeStore = new CoffeeStore();
        // 测试

        Coffee coffee = coffeeStore.orderCoffee("latte");

        System.out.println(coffee.getName());

        // 生成美咖啡
        Coffee coffee2 = coffeeStore.orderCoffee("american");
        System.out.println(coffee2.getName());

    }
}
