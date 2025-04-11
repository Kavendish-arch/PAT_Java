package com.colleciton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * 集合遍历方式3
 * lambda 表达式
 *
 */
public class CollectionTraversalDemo5 {
    public static void main(String[] args) {
        // 目标：掌握Collection的遍历方式三：lambda
        Collection<String> names = new ArrayList<>();
        names.add("张无忌");
        names.add("玄冥二老");
        names.add("宋青书");
        names.add("殷素素");

        names.forEach(
                new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        System.out.println(s);
                    }
                }
        );

//        names.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

        names.forEach(s -> System.out.println(s));

        names.forEach(System.out::println);
    }
}
