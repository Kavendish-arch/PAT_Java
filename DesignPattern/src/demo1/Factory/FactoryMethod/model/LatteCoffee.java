package demo1.Factory.FactoryMethod.model;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demo1.Factory.FactoryBefore
 * @className demo1.Factory.FactoryBefore.LatteCoffee
 * @date 2024/10/22 17:07
 * @description 拿铁咖啡 子类
 */
public class LatteCoffee extends Coffee {
    @Override
    public String getName()
    {
        return "拿铁咖啡";
    }

}

