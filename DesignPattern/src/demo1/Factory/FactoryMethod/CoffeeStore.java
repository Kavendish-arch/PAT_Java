package demo1.Factory.FactoryMethod;

import demo1.Factory.FactoryMethod.factory.CoffeeFactory;
import demo1.Factory.FactoryMethod.model.Coffee;

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
    private CoffeeFactory factory;

    public CoffeeStore(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee(String type) {
        Coffee coffee = factory.createCoffee();
        coffee.addSugar();
        coffee.addmilk();
        return coffee;
    }

    public static void main(String[] args) {

    }
}
