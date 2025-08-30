package com.chen.dpattern.Factory.Factory_Method;

import com.chen.dpattern.Factory.Factory_Method.factory.CoffeeFactory;
import com.chen.dpattern.Factory.Factory_Method.model.Coffee;

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

    private final CoffeeFactory factory;

    public CoffeeStore(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();
        coffee.addSugar();
        coffee.addmilk();
        return coffee;
    }


}
