import java.util.Arrays;
import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        for(int i= 1; i< 10; i++)
        {
            stack.push(i);
        }
//        int [] arr = Arrays.stream(stack).toIntArray();

//        for(int i = 0; i < arr.length; i++)
//        {
//            System.out.println(arr[i]);
//        }
        int res = stack.peek();
        System.out.println(res);

        stack.pop();


    }
}
