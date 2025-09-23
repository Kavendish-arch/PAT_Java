package com.chen.Sort.trans;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName 排序
 * @package trans
 * @className trans.AutoPackage
 * @date 2024/10/28 15:38
 * @description 自动装箱和拆箱
 */
public class equalDemo {
    /*
    Java是一种面向对象编程的语言，但他同时也提供了基本数据类型，提供基本数据类型是出于性能方面的考虑：因为使用对象来处理即使是最简单的计算，系统也销也比较大。
    Java中的基本数据类型没有方法和属性，但是在特定场景下，我们必须要利用对象的相关属性，而包装类就是为了让基本数据类型拥有方法和属性，实现对象化交互。

     */
    public static void main(String[] args) {
        Integer i = 1; // 自动装箱 Integer i = Integer.valueOf(1);
        int j = i;
        System.out.println(Integer.valueOf(1) == 1);
        System.out.println(i + j);
        /*
        == 1. 基本数据类，比较值
        2. 引用数据类型，比较地址

        equals() 比较值
        1. 默认情况下比较地址
         */
        // 基本数据类==
        int a = 2;
        int b = 2;
        System.out.println(a == b); // true
        System.out.println(Integer.valueOf(a).equals(Integer.valueOf(b))); // true
        int c = 128;
        int d = 128;
        System.out.println(c == d);
        System.out.println(Integer.valueOf(c).equals(Integer.valueOf(d)));

        Integer e = 128;
        Integer f = 128;
        System.out.println(e == f);
        System.out.println(e.equals(f));

        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "abc";

        System.out.println("==================================");
        System.out.println(s1 == s2); // 地址不同两个对象
        System.out.println(s1.equals(s2)); // 值一样
        System.out.println(s1 == s3); // 地址一样 字面量
        System.out.println(s1.equals(s3)); // 值一样


        System.out.println("==================================");
        String s4 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaakkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk";
        String s5 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaakkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk";
        System.out.println(s4 == s5);
        System.out.println(s4.equals(s5));

        equalDemo a1 = new equalDemo();
        equalDemo a2 = new equalDemo();

        System.out.println("==================================");
        System.out.println("自定义对象的默认equals方法");
        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));


        System.out.println("==================================");
        System.out.println("包装类的默认equals方法");
        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1.equals(i2));
        System.out.println(i1 == i2);

        String s6 = "123111";
        String s7 = new String("123111");
        String s8 = new String("123111");
        String s9 = "123111";
        System.out.println("==================================");
        System.out.println(s6==s7);
        System.out.println(s7==s8);

        System.out.println("==================================");
        System.out.println(s8 == s9);

    }
}
