package setDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package setDemo
 * @className setDemo.ParamDemo1
 * @date 2024/11/16 18:52
 * @description 可变参数
 */
public class ParamDemo1 {
    public static void sum (int a, int ... nums){
        System.out.println(nums.length);

    }

    public static void main(String[] args) {
        sum(1,2,3,4,5);
        int[] nums = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
//        Collections.sort(
//                Arrays.asList(nums),
//                (a,b)-> b-a
//        );
    }
}
