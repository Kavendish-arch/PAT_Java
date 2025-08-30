package com.chen.dpattern.Factory.Simple_Factory;

import com.chen.dpattern.Factory.Simple_Factory.model.Coffee;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demo1.Factory.FactoryBefore
 * @className demo1.Factory.FactoryBefore.CoffeeSotre
 * @date 2024/10/22 17:08
 * @description 咖啡店
 * 代表业务
 * 不需要太多修改
 */
public class CoffeeStore {
    public Coffee orderCoffee(String type) {

        // 创建工厂
        SimpleFactory simpleFactory = new SimpleFactory();
        // 创建产品
        Coffee coffee = simpleFactory.orderCoffee(type);
        // 后续逻辑
        coffee.addSugar();
        coffee.addmilk();
        return coffee;
    }

}
