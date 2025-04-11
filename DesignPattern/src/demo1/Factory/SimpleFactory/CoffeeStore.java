package demo1.Factory.SimpleFactory;

import demo1.Factory.SimpleFactory.model.Coffee;

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
    public Coffee orderCoffee(String type)
    {
//        SimpleFactory simpleFactory = new SimpleFactory();
        Coffee coffee = SimpleFactory.orderCoffee(type);
        coffee.addSugar();
        coffee.addmilk();
        return coffee;
    }

    public static void main(String[] args) {
//        CoffeeStore coffeeStore = new CoffeeStore();
//        Coffee coffee = Coff.orderCoffee("american");
//        System.out.println(coffee.getName());

    }
}
