package demo1.Factory.FactoryMethod;

import demo1.Factory.FactoryMethod.factory.AmericanCoffeeFactory;
import demo1.Factory.FactoryMethod.factory.CoffeeFactory;
import demo1.Factory.FactoryMethod.model.Coffee;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demo1.Factory.FactoryBefore
 * @className demo1.Factory.FactoryBefore.TestCoffeeStore
 * @date 2024/10/22 17:10
 * @description 测试咖啡店类
 */
public class TestCoffeeStore {
    public static void main(String[] args) {
        CoffeeFactory factory = new AmericanCoffeeFactory();
        CoffeeStore coffeeStore = new CoffeeStore(factory);

        Coffee coffee = coffeeStore.orderCoffee("latte");
        System.out.println(coffee.getName());

    }
}
