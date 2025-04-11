package IteratorDemo;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        // 添加元素
        list.add("王二");
        list.add("沉默");
        list.add("陈清扬");


        for(String s : list) {
            System.out.println(s);

        }

        // 迭代器；遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext())
        {
            String s = it.next();
            System.out.println(s);
        }
    }
}
