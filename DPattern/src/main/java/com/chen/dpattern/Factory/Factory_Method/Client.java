package com.chen.dpattern.Factory.Factory_Method;

import com.chen.dpattern.Factory.Factory_Method.factory.AmericanCoffeeFactory;
import com.chen.dpattern.Factory.Factory_Method.factory.LatteCoffeeFactory;
import com.chen.dpattern.Factory.Factory_Method.model.Coffee;

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
        CoffeeStore coffeeStore = new CoffeeStore(new AmericanCoffeeFactory());
        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());

        coffeeStore = new CoffeeStore(new LatteCoffeeFactory());
        coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());
    }
}
