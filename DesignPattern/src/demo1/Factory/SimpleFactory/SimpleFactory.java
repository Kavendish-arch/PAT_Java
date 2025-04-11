package demo1.Factory.SimpleFactory;

import demo1.Factory.SimpleFactory.model.AmericanCoffee;
import demo1.Factory.SimpleFactory.model.Coffee;
import demo1.Factory.SimpleFactory.model.LatteCoffee;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demo1.Factory.FactoryBefore.demo1.Factory
 * @className demo1.Factory.FactoryBefore.demo1.Factory.SimpleFacotry
 * @date 2024/10/22 17:18
 * @description 简单工厂模式
 */
public class SimpleFactory {


    public static Coffee orderCoffee(String type)
    {
        Coffee coffee = null;
        if ("american".equals(type))
        {
            // 依赖子类， 开闭原则
            coffee = new AmericanCoffee();
        }
        else if ("latte".equals(type))
        {
            coffee = new LatteCoffee();
        }
        else {
            System.out.println("对不起，您所点的咖啡没有");
        }
        return coffee;
    }
}
