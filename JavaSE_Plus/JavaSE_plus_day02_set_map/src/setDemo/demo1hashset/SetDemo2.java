package setDemo.demo1hashset;

import java.util.HashSet;
import java.util.Set;

/**
 * 需求， 自定义去重
 * 1. 需求：定义一个学生类，有姓名，年龄，地址，学号，要求，姓名，年龄，地址，学号不能重复。
 * 2. 分析：
 * 定义学生类
 *
 */
public class SetDemo2 {
    public static void main(String[] args) {
        // 目标：掌握HashSet集合去重操作。
        Student s1 = new Student("张三", 18, "北京", "123456");
        Student s2 = new Student("李四", 19, "上海", "989876");
        Student s3 = new Student("张三", 18, "北京", "123456");
        Student s4 = new Student("李四", 19, "上海", "989876");

        Set<Student> set = new HashSet<>(); // 不重复的！
        // 1. HashCode 2. equal 重写
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);

        System.out.println(set);
    }
}
