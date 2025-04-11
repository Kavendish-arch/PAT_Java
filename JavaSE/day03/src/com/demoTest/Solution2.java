package com.demoTest;

import java.util.Scanner;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package com.demoTest
 * @className com.demoTest.Solution2
 * @date 2024/11/17 21:56
 * @description ```java 需求:
 * 1.根据程序员的工龄(整数)给程序员涨工资(整数),程序员的工龄和基本工资通过键盘录入
 * 2.涨工资的条件如下：
 * [10-15)     +20000
 * [5-10)      +10000
 * [3~5)       +5000
 * [1~3)       +3000
 * <p>
 * 3.运行程序:
 * 请输入作为程序员的你的工作的工龄:10
 * 请输入作为程序员的你的基本工资为:60000
 * 程序运行后打印格式
 * "您目前工作了10年，基本工资为 60000元, 应涨工资 20000元,涨后工资 80000元"
 * 实现步骤:
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入作为程序员的你的工作的工龄:");
        int year = scanner.nextInt();
        System.out.println("请输入作为程序员的你的基本工资为:");
        int money = scanner.nextInt();

        int addMoney = 0;
        if (year >= 10 && year < 15) {
            addMoney = 20000;
        } else if (year >= 5 && year < 10) {
            addMoney = 10000;
        } else if (year >= 3 && year < 5) {
            addMoney = 5000;
        } else if (year >= 1 && year < 3) {
            addMoney = 3000;
        } else {
            System.out.println("您输入的工作年限不符合要求");
//            return;
        }

        System.out.println("您目前工作了 " + year + " 年，基本工资为 " + money + " 元, 应涨工资 " +
                addMoney + " 元,涨后工资 " + (addMoney + money) + "元");
    }
}
