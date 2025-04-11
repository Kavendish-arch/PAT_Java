package com.colleciton.SetDemo;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {

        HashSet<Character> hashSet = new HashSet<>();

        hashSet.add('a');
        hashSet.add('b');
        hashSet.add('a');

        for(char s:hashSet)
        {
            System.out.println(s);
        }
        System.out.println(hashSet);
        // 创建一个新的HashSet
        HashSet<String> set = new HashSet<>();

        // 添加元素
        set.add("沉默");
        set.add("王二");
        set.add("陈清扬");

        // 输出HashSet的元素个数
        System.out.println("HashSet size: " + set.size()); // output: 3

        // 判断元素是否存在于HashSet中
        boolean containsWanger = set.contains("王二");
        System.out.println("Does set contain '王二'? " + containsWanger); // output: true

        // 删除元素
        boolean removeWanger = set.remove("王二");
        System.out.println("Removed '王二'? " + removeWanger); // output: true

        // 修改元素，需要先删除后添加
        boolean removeChenmo = set.remove("沉默");
        boolean addBuChenmo = set.add("不沉默");
        System.out.println("Modified set? " + (removeChenmo && addBuChenmo)); // output: true

        // 输出修改后的HashSet
        System.out.println("HashSet after modification: " + set); // output: [陈清扬, 不沉默]
    }
}
