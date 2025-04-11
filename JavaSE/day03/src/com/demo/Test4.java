package com.demo;

public class Test4 {
    public static void main(String[] args) {
        // 目标：找出101-200之间的全部素数。
        int count = 0;
        // 1、遍历101-200
        for (int i = 101; i <= 200; i++) {
            // i = 101 102 103 103 ... 200
            // 2、每遍历到一个数字，判断这个数字是否是素数，是则输出。（独立功能独立成方法）
            if (isPrime(i)) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println("素数的个数为：" + count);
    }

    public static boolean isPrime(int num) {
        // num = 101
        // 定义一个循环从2开始找到该数的一半，只要发现有一个数字能整数num这个数，num就不是素数
        // 如果都没有找到，那么num就是素数
        for (int i = 2; i <= num / 2; i++) {
            // i = 2 3 4 5 ...
            // 2、判断num是否能被i整除，能则返回false，不能则返回true
            if (num % i == 0) {
                return false;
            }
        }
        return true; // 是素数。
    }
}
