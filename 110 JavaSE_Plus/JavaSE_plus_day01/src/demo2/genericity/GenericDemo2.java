package demo2.genericity;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo2genericity
 * @className demo2genericity.GenericDemo2
 * @date 2024/11/13 19:52
 * @description 自定义泛型类
 */
public class GenericDemo2 {
    public static void main(String[] args)
    {
        // 创建一个泛型为String的泛型类对象
        MyArrayList<String> list = new MyArrayList<String>();

        list.add("hello");
        list.add("world");

        System.out.println(list.toString());
    }


}
