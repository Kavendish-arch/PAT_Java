package com.chen.dpattern.Factory.config_factory;

import com.chen.dpattern.Factory.config_factory.vo.Coffee;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class CoffeeFactory {

    // 加载配置文件，获取配置文件的全类名
    // 1. 定义容器对象存储咖啡对象
    private static HashMap<String, Object> map = new HashMap<>();

    // 2. 加载配置文件

    static {
        try (InputStream is = CoffeeFactory.class.getClassLoader()
//                .getResourceAsStream("/Users/chenyingtao/Desktop/cPlus/Java/PAT_Java/DesignPattern/src/com/chen/DemoFactory/config_factory/bean.properties")) {
                .getResourceAsStream("bean.properties")) {

            if (is == null) {
                throw new RuntimeException("配置文件 bean.properties 未找到");
            }

            Properties properties = new Properties();
            properties.load(is);

            Set<String> keys = properties.stringPropertyNames(); // 更安全地获取字符串键集合
            for (String key : keys) {
                String className = properties.getProperty(key);
                Class<?> clazz = Class.forName(className);

                // 类型检查，确保是 Coffee 的子类
                if (!Coffee.class.isAssignableFrom(clazz)) {
                    throw new IllegalArgumentException(
                            "配置中的类 " + className + " 不是 Coffee 的子类");
                }

                Coffee coffee = (Coffee) clazz.getDeclaredConstructor().newInstance();
                map.put(key, coffee);
                System.out.println(key + " = " + coffee);
            }
        } catch (IOException e) {
            throw new RuntimeException("加载配置文件时发生 IO 错误", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("找不到指定的类: " + e.getMessage(), e);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException("反射创建实例失败: " + e.getMessage(), e);
        }
    }

    //    static {
//        //
//        Properties properties = new Properties();
//
//        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("/Users/chenyingtao/Desktop/cPlus/Java/PAT_Java/DesignPattern/src/com/chen/DemoFactory/config_factory/bean.properties");
//
//        try {
//            properties.load(is);
//            Set<Object> keys = properties.keySet();
//            for (Object key : keys) {
//                String className = properties.getProperty((String) key);
//                // 利用反射
//                Class<?> clazz = Class.forName(className);
//                Coffee coffee = (Coffee) clazz.getDeclaredConstructor().newInstance();
//                map.put((String) key, coffee);
//                System.out.println(key + " = " + coffee);
//            }
//        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException |
//                 NoSuchMethodException | InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
    public static Coffee createCoffee(String type) {
        System.out.println("map = " + map);
        return (Coffee) map.get(type);
    }
}
