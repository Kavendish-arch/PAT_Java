package com.demoTest;

import java.util.Scanner;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package com.demoTest
 * @className com.demoTest.Solution1
 * @date 2024/11/17 22:01
 * @description 需求: 	让用户依次录入三个整数，求出三个数中的最大值，并打印到控制台。【使用if】 	 实现步骤:
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入三个整数:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a > b && a > c) {
            System.out.println(a);
        } else if (b > a && b > c) {
            System.out.println(b);
        } else {
            System.out.println(c);
        }
    }
}
