package stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamDemo {

    public static void main(String[] args)
    {
        //求最大值
        int[] arr = new int[]{1,2,3,4,5,6,};
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println(max);
        Arrays.stream(arr).forEach(System.out::println);

        // map 对数组中的每一个元素进行操作
        IntStream intStream = Arrays.stream(arr).map(b -> b + 1);
        intStream.forEach(System.out::println);

        IntStream intStream1 = Arrays.stream(arr).filter(b -> b % 2 == 0);
        intStream1.forEach(System.out::print);
    }
}
