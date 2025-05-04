package org.example;

public class Cat {

    String name;
    public Cat(String name){
        this.name = name;
    }

    private Cat(){
        System.out.println("私有 cat constructor");
    }
}
