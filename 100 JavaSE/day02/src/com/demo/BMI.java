package com.demo;

import java.util.Scanner;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package com.demo
 * @className com.demo.BMI
 * @date 2024/11/17 21:42
 * @description 开发一个简单的健康计算器应用程序，它可以接受用户的输入（如年龄、性别、体重、身高），并计算出用户的BMI（身体质量指数）和基础代谢率（BMR）。
 */
public class BMI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 输入用户信息
        System.out.println("请输入用户年龄:");
        int age = scanner.nextInt(); // 年龄
        char gender = '男'; // 性别
        double weight = 70.5; // 体重（kg）
        double height = 1.75; // 身高（m）
        //
        System.out.println("请输入用户性别:");
        gender = scanner.next().charAt(0);

        System.out.println("请输入用户体重和身高:");
        weight = scanner.nextDouble();
        height = scanner.nextDouble();

        // 计算BMI
        double bmi = calculateBMI(weight, height);


        // 计算BMR
        double bmr = calculateBMR(weight, height, String.valueOf(gender), age);


        System.out.println("BMI: " + bmi + "\nBMR: " + bmr);

    }
    public static double calculateBMR(double weight, double height, String sex, int age) {
        return switch (sex) {
            case "男" -> 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
            case "女" -> 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
            default -> -1;
        };
    }
    public static double calculateBMI( double weight, double height) {
        return weight / (height * height);
    }
}
