package com.dcl_Sing;

import java.io.Serializable;


/**
 * 单例模式
 * double check locking
 * 实现方式：
 * 1. 检查实例是否存在
 * 2. 加锁，再检查实例是否存在
 * 
 */
public final class Single implements Serializable {
    private Single() {
    }

    // volatile 保证可见性, 禁止指令重拍
    private static volatile Single single = null;

    public static Single getSingle() {
        // 1. 线程不安全
        /*
         * 线程不安全
         * if(single == null){
         * single = new Single();
         * }
         */
        // 2. 双重检查 synchronized
        // 第一次检查
        if (single == null) {
            // 首次访问会 加锁
            synchronized (Single.class) {
                // 第二次检查
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }

    // 反序列化，不采用字节码对象创建对象，直接返回单例对象
    public Object readResolve() {
        return single;
    }

    public static void main(String[] args) {
        System.out.println(Single.getSingle());
    }
}

/**
 * 单例模式有很多实现方法，饿汉、懒汉、静态内部类、枚举类，试分析每种实现下获取单例对象（即调用
 * getInstance）时的线程安全，并思考注释中的问题
 * 饿汉模式
 * 
 * 懒汉模式
 * 
 * 1. final
 * 2. 序列化反序列化
 * 3. 设置为私有， 能否防止反射创建实例，
 * 4. 静态成员变量，能防止创建对象的线程安全问题
 * 5. 为什么提供方法，而不是提供成员变量
 */

// 问题1：枚举单例是如何限制实例个数的
// 问题2：枚举单例在创建时是否有并发问题 静态成员变量
// 问题3：枚举单例能否被反射破坏单例 不能
// 问题4：枚举单例能否被反序列化破坏单例 不能
// 问题5：枚举单例属于懒汉式还是饿汉式 饿汉式
// 问题6：枚举单例如果希望加入一些单例创建时的初始化逻辑该如何做
enum Singleton {
    INSTANCE;

    Singleton() {
        System.out.println("init");
        // do something
    }

    public void doSomething() {
        // do something
    }
}

// 懒汉式

class SingletonLazy {
    private static SingletonLazy instance = null;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new SingletonLazy();
        return instance;
    }
}

class SingletonLazyDoubleCheck {
    private SingletonLazyDoubleCheck() {
    }

    // 问题1：解释为什么要加 volatile ?
    private static volatile SingletonLazyDoubleCheck INSTANCE = null;

    // 问题2：对比实现3, 说出这样做的意义
    public static SingletonLazyDoubleCheck getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        synchronized (Singleton.class) {
            // 问题3：为什么还要在这里加为空判断, 之前不是判断过了吗
            if (INSTANCE != null) { // t2
                return INSTANCE;
            }
            // 问题4：如果这里不加判断，会发生什么？
            // 构造方法 和 赋值操作不是原子性操作
            INSTANCE = new SingletonLazyDoubleCheck();
            return INSTANCE;
        }
    }
}

final class SingletonLazyStaticInnerClass {
    private SingletonLazyStaticInnerClass() {
    }

    // 静态内部类 创建单例 线程安全 懒汉式
    private static class SingletonHolder {
        private static final SingletonLazyStaticInnerClass INSTANCE = new SingletonLazyStaticInnerClass();
    }

    public static SingletonLazyStaticInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}