package demo2.genericity.method;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo2.genericity.method
 * @className demo2.genericity.method.GenericDemo4
 * @date 2024/11/13 20:04
 * @description 泛型方法
 */
public class GenericDemo4 {
    public static void main(String[] args)
    {
        // 打印任意数组内容
        Integer[] a = {1, 2, 3, 4, 5};
        Double[] b = {1.1, 2.2, 3.3, 4.4, 5.5};
        String[]  s = {"hello", "world", "java"};
        printArray(a);
        printArray(b);
        printArray(s);
    }
    public static  <T> void printArray(T[] array)
    {
        for (T t : array) {
            System.out.println(t);
        }
    }

    public static <T> T get(T[] data)
    {
        return data[0];
    }
}
