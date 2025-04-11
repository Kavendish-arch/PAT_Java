package demo3Stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo3Stream
 * @className demo3Stream.demo
 * @date 2024/11/12 19:22
 * @description
 */
public class demo {
//    public void method(){
//        SubClass s = new SubClass("hello");
//        BaseClass b = new BaseClass("world");
//    }
    public static void main(String[] args)
    {
        int[] scores = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12};
        sortHandle(scores, scores.length, 10);
        for (int i : scores) {
            System.out.println(i);
        }
    }
    public static void sortHandle(int[] scores, int x, int y)
    {
        List<Integer> list = new ArrayList<>();
//        boolean flag = true;
        for(int i = 0; i < scores.length; i++)
        {
            if (scores[i] < y && scores[i+1] >= x)
            {
                list.add(y);
            }
            list.add(scores[i]);
        }
        scores = list.stream().mapToInt(Integer::intValue).toArray();
    }
}

class BaseClass{
    public String str;
    public BaseClass(){
        System.out.println("ok");
    }
    public BaseClass(String str){
        this.str = str;
    }
}
class SubClass extends BaseClass{
//    public SubClass(String hello) {
//    }
}
