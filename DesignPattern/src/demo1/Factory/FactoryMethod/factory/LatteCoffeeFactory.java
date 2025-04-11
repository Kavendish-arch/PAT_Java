package demo1.Factory.FactoryMethod.factory;

import demo1.Factory.FactoryMethod.model.Coffee;
import demo1.Factory.FactoryMethod.model.LatteCoffee;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demo1.Factory.FactoryMethod.factory
 * @className demo1.Factory.FactoryMethod.factory.LatteCoffeeFactory
 * @date 2024/10/22 17:34
 * @description 拿铁咖啡工厂
 */
public class LatteCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
