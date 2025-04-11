package demo1.Factory.AbstractFactory;

public class CoffeeStore {

    public static Coffee orderCoffee(String type) {
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        }
        //添加配料
        coffee.addMilk();
        coffee.addSuqar();
        return coffee;
    }

}

class Coffee {

    public void addMilk() {
        //打印三行hellowor
    }

    public void addSuqar() {

    }

    public String getName() {
        return "";
    }
}

class AmericanCoffee extends Coffee {

}

class LatteCoffee extends Coffee {

}
