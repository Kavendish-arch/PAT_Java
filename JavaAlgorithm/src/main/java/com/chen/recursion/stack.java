import java.util.LinkedList;
import java.util.Stack;

public class stack{
    
    public stack(){
        
    }
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<Integer>();

        // 入栈操作
        stack1.push(1);
        stack1.push(1);
        stack1.push(1);
        stack1.push(1);
        stack1.push(8);

        System.out.println(stack1.peek());

        // 出栈操作
        System.out.println(stack1.pop());
        // 
        System.out.println(stack1.peek());

        LinkedList<Integer> queue2 = new LinkedList<>(); 
        queue2.offer(2);
        queue2.offer(8);
        queue2.offer(3);

        System.out.println(queue2.peek()); 
        
        System.out.println(queue2.poll()); 

        System.out.println(queue2.peek()); 


    }
}