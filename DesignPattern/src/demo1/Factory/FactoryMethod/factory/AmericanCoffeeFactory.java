package demo1.Factory.FactoryMethod.factory;

import demo1.Factory.FactoryMethod.model.AmericanCoffee;
import demo1.Factory.FactoryMethod.model.Coffee;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demo1.Factory.FactoryBefore.demo1.Factory
 * @className demo1.Factory.FactoryBefore.demo1.Factory.SimpleFacotry
 * @date 2024/10/22 17:18
 * @description 工厂方法模式
 */
public class AmericanCoffeeFactory implements CoffeeFactory{

    public Coffee createCoffee(){
            return new AmericanCoffee();
    }



}
