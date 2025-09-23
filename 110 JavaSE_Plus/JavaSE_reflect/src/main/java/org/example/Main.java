package org.example;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * 利用**反射**创建的对象**可以无视修饰符**调用类里面的内容
 * 可以跟**配置文件结合起来使用**，把要创建的对象信息和方法写在配置文件中。
 * 读取到什么类，就创建什么类的对象
 * 读取到什么方法，就调用什么方法
 * 此时当需求变更的时候不需要修改代码，只要修改配置文件即可。
 * <p>
 * 反射都是从class字节码文件中获取的内容。
 * <p>
 * - 如何获取class字节码文件的对象
 * - 利用反射如何获取构造方法（创建对象）
 * - 利用反射如何获取成员变量（赋值，获取值）
 * - 利用反射如何获取成员方法（运行）
 * <p>
 * 1.3 获取字节码文件对象的三种方式
 * <p>
 * * Class这个类里面的静态方法forName（“全类名”）**（最常用）**
 * - 通过class属性获取
 * - 通过对象获取字节码文件对象
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        // 1. 获取字节码文件对象的三种方式
        //  通过class属性获取
        /*
         1. Class这个类里面的静态方法forName
         * //Class.forName("类的全类名")： 全类名 = 包名 + 类名
         * //源代码阶段获取 --- 先加载到内存中，再获取字节码文件的对象
         * //clazz 就表示这个类的字节码文件对象。
         * //就是当class这个文件加载到内存之后，产生的字节码文件对象
         */
        Class clazz = Class.forName("org.example.Dog");
        System.out.println(clazz);

        //2.通过class属性获取
        //类名.class
        Class clazz2 = Dog.class;
        System.out.println(clazz2);
        //因为class文件在硬盘中是唯一的，所以，当这个文件加载到内存之后产生的对象也是唯一的
        System.out.println(clazz2 == clazz);

        //3.通过Student对象获取字节码文件对象
        Dog dog = new Dog();
        Class clazz3 = dog.getClass();
        System.out.println(clazz3);

        System.out.println(clazz == clazz3);
        System.out.println(clazz2 == clazz3);


        // 获取构造方法
        System.out.println("默认的构造方法");
        Constructor<Dog> constructor = clazz.getConstructor();
        System.out.println(constructor);

        List<Constructor> constructorList = List.of(clazz.getConstructors());
        for (Constructor constructor1 : constructorList) {
            System.out.println(constructor1);
        }
        System.out.println("自定义构造函数后，不会生成默认的无参构造函数");
        Class clazz4 = Class.forName("org.example.Cat");
        for (Constructor constructor1 : List.of(clazz4.getConstructors())) {
            System.out.println(constructor1);
        }
        System.out.println("获取所有的构造函数");
        for (Constructor constructor1 : List.of(clazz4.getDeclaredConstructors())) {
            System.out.println(constructor1);
        }
    }
}