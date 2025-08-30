package com.chen.dpattern.Factory.Abstract_Factory;

import com.chen.dpattern.Factory.Abstract_Factory.ft.DessertFactory;
import com.chen.dpattern.Factory.Abstract_Factory.ft.ItalyDessertFactory;
import com.chen.dpattern.Factory.Abstract_Factory.vo.Coffee;
import com.chen.dpattern.Factory.Abstract_Factory.vo.Dessert;

public class CoffeeStore {
    private final DessertFactory factory;


    public CoffeeStore(DessertFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee(String type) {

        Coffee coffee = factory.createCoffee();
        //添加配料
        coffee.addMilk();
        coffee.addSuqar();
        return coffee;
    }

    public Dessert orderDessert() {
        Dessert dessert = factory.createDessert();
        return dessert;
    }

    public static void main(String[] args) {
        CoffeeStore store = new CoffeeStore(new ItalyDessertFactory());
        Coffee coffee = store.orderCoffee("american");
    }
}


