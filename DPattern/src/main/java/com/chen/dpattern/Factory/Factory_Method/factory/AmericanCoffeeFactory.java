package com.chen.dpattern.Factory.Factory_Method.factory;

import com.chen.dpattern.Factory.Factory_Method.model.AmericanCoffee;
import com.chen.dpattern.Factory.Factory_Method.model.Coffee;

/**
 * 美式咖啡工厂类，用于创建美式咖啡对象
 * 该类实现了CoffeeFactory接口，提供了具体的咖啡创建逻辑
 */
public class AmericanCoffeeFactory implements CoffeeFactory{

    /**
     * 创建咖啡的方法
     *
     * @return Coffee 返回一个美式咖啡对象
     *
     * 该方法是AmericanCoffeeFactory类的核心方法，负责实例化并返回一个美式咖啡对象
     * 通过这个工厂方法，客户端可以间接创建咖啡对象，而无需直接使用new操作符
     * 这样做降低了客户端与具体咖啡类之间的耦合度
     */
    public Coffee createCoffee(){
        return new AmericanCoffee();
    }

}
