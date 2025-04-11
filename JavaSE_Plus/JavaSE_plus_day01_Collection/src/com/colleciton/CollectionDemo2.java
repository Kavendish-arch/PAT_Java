package com.colleciton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Collection提供的通用集合功能
 * 1、Collection提供的通用集合功能：
 * 1）添加元素：add(E e)
 * 2）获取元素个数：size()
 * 3）删除元素：remove(Object o)
 * 4）判断是否为空：isEmpty()
 * 5）清空集合：clear()
 * 6）判断是否包含某个元素：contains(Object o)
 * 7）把集合转换成数组：toArray()
 * 拓展：把集合转换成字符串数组
 *
 * 2. 遍历
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        // 目标：搞清楚Collection提供的通用集合功能。
        Collection<String> list = new ArrayList<>();

        // 添加元素
        list.add("张三");
        list.add("李四");
        list.add("王五");
        System.out.println(list); // [张三, 李四, 王五]

        // 获取集合的元素个数
        System.out.println(list.size());

        // 删除集合元素
        list.remove("李四");
        System.out.println(list);

        // 判断集合是否为空
        System.out.println(list.isEmpty()); // false

        // 清空集合
//         list.clear();
//         System.out.println(list);

        // 判断集合中是否存在某个数据
        System.out.println(list.contains("张三"));

        // 把集合转换成数组
        Object[] arr = list.toArray();
        System.out.println(Arrays.toString(arr));

        // 把集合转换成字符串数组(拓展)
        String[] arr2 = list.toArray(String[]::new);
//        String[] arr2 = list.toArray(value -> new String[value]);
//        String[] arr2 = list.toArray(new IntFunction<String[]>() {
//            @Override
//            public String[] apply(int value) {
//                return new String[value];
//            }
//        });
        System.out.println(Arrays.toString(arr2));

        Collection<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);


        Integer[] arr3 = list2.toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr3));
        System.out.println(arr3[0]);
    }
}
