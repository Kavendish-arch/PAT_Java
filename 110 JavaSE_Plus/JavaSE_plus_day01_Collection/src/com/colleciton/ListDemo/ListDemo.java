package com.colleciton.ListDemo;

import java.util.ArrayList;
import java.util.HashSet;

public class ListDemo {

    public static void main(String[] args) {
        ListDemo listDemo = new ListDemo();
        listDemo.testArrayList();
        listDemo.testSet();

        // 创建一个集合
        ArrayList<String> list = new ArrayList<String>();
        // 添加元素
        list.add("王二");
        list.add("沉默");
        list.add("陈清扬");

        // 遍历集合 for 循环
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
        // 遍历集合 for each
        for (String s : list) {
            System.out.println(s);
        }

        // 删除元素
        list.remove(1);
        // 遍历集合
        for (String s : list) {
            System.out.println(s);
        }

        // 修改元素
        list.set(1, "王二狗");
        // 遍历集合
        for (String s : list) {
            System.out.println(s);
        }
    }

    public void testArrayList()
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("java");
        list.add("java");
        list.add("java");
        list.add("java");
        list.add("java");
        list.add("java");
        System.out.println(list);
    }

    public void testSet()
    {
        HashSet<String> set = new HashSet<String>();
        set.add("hello") ;
        set.add("world") ;
        set.add("java") ;
        set.add("java") ;
        set.add("java") ;
        set.add("java") ;
        System.out.println(
                set
        );
    }
}
