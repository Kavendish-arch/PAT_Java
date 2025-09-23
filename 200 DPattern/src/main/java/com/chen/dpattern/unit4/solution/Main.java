package com.chen.dpattern.unit4.solution;

public class Main {


    class A{
        A(int num){}
    }
    class B extends A{
        B(){
            super(1);
        }
    }



    public static void main(String[] args) {
        System.out.println("Hello world!");
        User user = new User();
        user.a = 1;

        User user1 = new User();
        user1.a = 2;

        System.out.println(user.a);
        System.out.println(user1.a);
        System.out.println(user.a == user1.a);

    }
}
class User{
    static int a;
}