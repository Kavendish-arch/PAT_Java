package demo3Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo3Stream
 * @className demo3Stream.StreamDemo
 * @date 2024/11/12 14:29
 * @description Stream流
 *
 * 数据源 集合数组
 * 1. 过滤
 * 2. 排序
 * 3. 去重
 *
 */
public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("张无忌");
        list.add("张无忌");
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张组");
        list.add("张翠山");
        list.add("张翠山");
        list.add("张翠山");
        list.add("张翠山");

        // 1. 传统方法
        List<String> newList = new ArrayList<>();
        for(String name : list)
        {
            if(name.startsWith("张") && name.length() == 3)
            {
                newList.add(name);
            }
        }
        System.out.println(newList);

        // 2. Stream 方法
        // filter 过滤
        /**
         * 中间方法
         * filter
         * sorted
         */
//        List<String> newList2 =list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).collect(Collectors.toList());
        List<String> newList2 =list.stream().filter(s -> s.startsWith("张") && s.length() == 3).collect(Collectors.toList());

        System.out.println(
                newList2
        );
        // 1. 过滤方法
        list.stream().filter(s -> s.startsWith("张") && s.length() == 3).forEach(System.out::println);

        List<Double> list2 = new ArrayList<>();
        list2.add(6.6);
        list2.add(3.3);
        list2.add(8.8);
        list2.add(1.1);
        list2.add(9.9);
        list2.add(5.5);
        list2.add(4.4);

        // 2. 排序
        list2.stream().sorted().forEach(System.out::println); // 默认升序
        list2.stream().sorted((o1, o2) -> -Double.compare(o1, o2)).forEach(System.out::println);// 降序排序

        System.out.println("limit ==================");
        // 3. limit
        list.stream().sorted((o1, o2) -> o1.length() - o2.length()).limit(2).forEach(System.out::println);

        System.out.println("skip ==================");
        // 4. skip跳过前两个
        list.stream().sorted((o1, o2) -> o1.length() - o2.length()).skip(2).limit(2).forEach(System.out::println);

        System.out.println("distinct ==================");
        // 5. distinct
        list.stream().sorted().distinct().forEach(System.out::println);
        System.out.println("no distinct ==================");
        list.stream().sorted().forEach(System.out::println);

        System.out.println("map =======================");
        // 6. map 映射加工方法
        list2.stream().map(d -> d * 100 + " %").forEach(System.out::println);

        // 7. concat

        String[] names = {"张无忌", "张无忌", "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张组", "张翠山", "张翠山", "张翠山", "张翠山"};
        String[] names2 = {"张无忌"};

        Stream<String> s1 = Stream.of(names);
        Stream<String> s2 = Stream.of(names2);
        Stream<Object> s3 = Stream.concat(s1, s2);
    }
}
