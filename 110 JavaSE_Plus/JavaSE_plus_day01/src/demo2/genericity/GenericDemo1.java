package demo2.genericity;

import java.util.ArrayList;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo2genericity
 * @className demo2genericity.GenericDemo1
 * @date 2024/11/13 14:02
 * @description 使用泛型的好处
 */
public class GenericDemo1 {
    public static void main(String[] args) {
        ArrayList<String > list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("python");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
