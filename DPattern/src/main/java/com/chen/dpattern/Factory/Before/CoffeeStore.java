package com.chen.dpattern.Factory.Before;

import com.chen.dpattern.Factory.Before.vo.AmericanCoffee;
import com.chen.dpattern.Factory.Before.vo.Coffee;
import com.chen.dpattern.Factory.Before.vo.LatteCoffee;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demo1.Factory.FactoryBefore
 * @className demo1.Factory.FactoryBefore.CoffeeSotre
 * @date 2024/10/22 17:08
 * @description 咖啡店
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type) {
        Coffee coffee = null;
        if ("american".equals(type)) {
            // 依赖子类， 开闭原则
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，您所点的咖啡没有");

        }

        // 添加配料
        coffee.addSugar();
        coffee.addmilk();
        return coffee;
    }

    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("american");
        System.out.println(coffee.getName());

    }
}
