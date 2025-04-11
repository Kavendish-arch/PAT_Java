package com.colleciton.ListDemo;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Character> charStack = new Stack<>();
        charStack.push('a');
        charStack.push('b');

        System.out.println(charStack.peek());
        charStack.pop();
        System.out.println(charStack.peek());
    }
}
