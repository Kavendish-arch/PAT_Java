package com.chen.dpattern.Factory.Factory_Method.factory;

import com.chen.dpattern.Factory.Factory_Method.model.Coffee;

/**
 * 抽象工厂方法
 */
public interface CoffeeFactory {
    Coffee createCoffee();
}
