package com.chen.dpattern.Decorator;

/**
* @projectName DesignPattern
* @package unit2.demo2
* @className unit2.demo2.DecoratorDemo

* @author chenyingtao
* @date 2025/4/10 14:43
* @version 1.0
* @description @todo 
*/
// 基础组件接口（咖啡）
interface Coffee {
    double getCost();
    String getDescription();
}

// 具体组件（基础咖啡）
class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 2.0; // 基础价格2元
    }

    @Override
    public String getDescription() {
        return "纯咖啡";
    }
}

// 装饰器抽象类（核心）
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    // 由子类实现具体装饰逻辑
    public abstract double getCost();
    public abstract String getDescription();
}

// 具体装饰器1（加牛奶）
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5; // 加价0.5元
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + "+牛奶";
    }
}

// 具体装饰器2（加糖）
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.3;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + "+糖";
    }
}

// 客户端使用
public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println("基础款：" + coffee.getDescription() + "，价格：" + coffee.getCost());

        coffee = new MilkDecorator(coffee); // 第一次装饰
        coffee = new SugarDecorator(coffee); // 第二次装饰

        System.out.println("豪华款：" + coffee.getDescription() + "，价格：" + coffee.getCost());
    }
}
/* 输出：
基础款：纯咖啡，价格：2.0
豪华款：纯咖啡+牛奶+糖，价格：2.8
*/
