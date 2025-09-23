package com.chen.dpattern.Factory.Abstract_Factory.ft;


import com.chen.dpattern.Factory.Abstract_Factory.vo.Dessert;
import com.chen.dpattern.Factory.Abstract_Factory.vo.Coffee;

public interface DessertFactory {

    Coffee createCoffee();

    Dessert createDessert();
}
