package com.chen.dpattern.Factory.Abstract_Factory.ft;

import com.chen.dpattern.Factory.Abstract_Factory.vo.Coffee;
import com.chen.dpattern.Factory.Abstract_Factory.vo.Dessert;
import com.chen.dpattern.Factory.Abstract_Factory.vo.ItalyCoffee;

public class ItalyDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffee() {
        return new ItalyCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Dessert();
    }
}
