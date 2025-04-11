import java.util.ArrayList;
import java.util.LinkedList;

public class leetcode1{
    public static void main(String[] args) {
        
        int x = (2 + (9-3)/x);
        System.out.println(x);
        int nums [] = {1,2,3,4,5,6};
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(i);

        }
        LinkedList<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list2.add(i);
        }
        // 队列

        int time = 10000000;
        
        // 添加实验
        long time_start = System.currentTimeMillis();
        for (int i = 0; i <= time; i++) {
            list1.add(i);
        }
        long time_end = System.currentTimeMillis();
        System.out.println("time " + (time_end - time_start)+ "ms");
        
        time_start = System.currentTimeMillis();
        for (int i = 0; i <= time; i++) {
            list2.add(i);
        }
        time_end = System.currentTimeMillis();
        System.out.println("time " + (time_end - time_start)+ "ms");
        
        time = 1000;
        
        time_start = System.currentTimeMillis();
        for (int i = 0; i <= time; i++) {
            list1.get(i);
        }
        time_end = System.currentTimeMillis();
        System.out.println("compare linklist and arrarylist read speed " + (time_end - time_start)+ "ms");
        
        time_start = System.currentTimeMillis();
        for (int i = 0; i <= time; i++) {
            list2.get(i);
        }
        time_end = System.currentTimeMillis();
        System.out.println("compare linklist and arrarylist read speed " + (time_end - time_start)+ "ms");

    }
}