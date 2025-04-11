package demo1.Factory.SimpleFactory;

import demo1.Factory.SimpleFactory.model.Coffee;

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
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("latte");

        System.out.println(coffee.getName());

        Coffee coffee2 = coffeeStore.orderCoffee("american");
        System.out.println(coffee2.getName());

//        Coffee coffee = SimpleFactory.orderCoffee("latte");
//
//        System.out.println(coffee.getName());
//
//        Coffee coffee2 = SimpleFactory.orderCoffee("american");
//        System.out.println(coffee2.getName());


    }
}
