package setDemo.demo2map;

//import com.itheima.demo1hashset.Teacher;

import setDemo.demo1hashset.Teacher;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapDemo7 {
    public static void main(String[] args) {
        // 目标：TreeMap集合（原理和用法于TreeSet一样）
        Map<Teacher, String> map = new TreeMap<>(
                (o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()
                )); // 按照键排序：升序
        map.put(new Teacher("老陈", 20, 6232.4), "462期");
        map.put(new Teacher("dlei", 18, 3999.5), "422期");
        map.put(new Teacher("老王", 22, 9999.9), "461期");
        map.put(new Teacher("老李", 20, 1999.9), "423期");
        System.out.println(map);

        Set<Teacher> set = new TreeSet<>(
//                (o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary())
        );
        set.add(new Teacher("老陈", 20, 6232.4));
        set.add(new Teacher("dlei", 18, 3999.5));
        set.add(new Teacher("老王", 22, 9999.9));
        set.add(new Teacher("老李", 20, 1999.9));
        System.out.println(set);
    }
}
