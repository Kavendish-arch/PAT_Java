package com.itheima.operator;

public class OperatorDemo1 {
    public static void main(String[] args) {
        // 目标：搞清楚基本的算术运算符。
        // print(10, 2);
        print(10, 3);

        System.out.println("---------------------------------");

        print2();
    }

    /**
     * 打印两个整数的各种运算结果
     * 包括加法、减法、乘法、除法和取余运算
     * 此方法演示了整数和浮点数除法的不同结果
     *
     * @param a 第一个整数
     * @param b 第二个整数，作为运算的除数
     */
    public static void print(int a, int b) {
        System.out.println(a + b); // 输出两个整数的和
        System.out.println(a - b); // 输出两个整数的差
        System.out.println(a * b); // 输出两个整数的乘积
        System.out.println(a / b); // 输出两个整数的商，结果为整数（例如：3.3333... ==> 3）
        System.out.println((double) a / b); // 将整数转换为浮点数后输出商，结果为浮点数（例如：3.3333...）
        System.out.println(1.0 * a / b); // 通过乘以浮点数1.0来转换整数为浮点数后输出商，结果为浮点数（例如：3.3333...）
        System.out.println(a % b); // 输出两个整数相除的余数
    }

    // 注释：
    // 需求：研究+符号做连接符还是做运算符.
    public static void print2() {
        int a = 5;
        System.out.println("abc" + a); // abc5
        System.out.println(a + 5); // 10
        System.out.println("itheima" + a + 'a'); // itheima5a
        System.out.println(a + 'a' + "itheima" + 12 + 5); // 102itheima
    }
}
