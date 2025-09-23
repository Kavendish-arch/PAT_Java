package demo2.genericity.method;

import demo2.genericity.MyArrayList;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo2.genericity.method
 * @className demo2.genericity.method.GenericDemo6
 * @date 2024/11/13 21:37
 * @description 泛型的支持类型
 */
public class GenericDemo6 {
    public static void main(String[] args) {
        // 目标： 泛型的支持类型 泛型和集合不支持基本数据类型
        MyArrayList<Integer> list = new MyArrayList<>();
        // 泛型擦除 泛型在运行前会被擦除， 即使是Integer类型，在运行前会被擦除为Object类型

        // 基本数据类型封装成包装类
        // 1. 手工包装
//        Integer j = new Integer(2);
        Integer it1 = Integer.valueOf(128); //
        Integer it2 = Integer.valueOf(128); //

        System.out.println(it1 == it2);

        // 2. 自动装箱，基本数据类型可以直接编程包装对象的数据， 不需要手工转换
        Integer i = 12090;
        Integer j = 12090;
        System.out.println(i == j);

        System.out.println("=====================");
        // 包装类功能
        // 1. 基本数据类型转字符串
//        int j = 12;
        int j2 = 12;
        String s =Integer.toString(j2);
        System.out.println(s);




        // 2. 把字符串数值转换为基本数据类型
        String s1 = "123";
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.valueOf(s1);

        String d2 = "12.3";
        double d3 = Double.parseDouble(d2);
        double d4 = Double.valueOf(d2);

        System.out.println(i1);
        System.out.println(i2);
        System.out.println(d3);
        System.out.println(d4);

    }
}
