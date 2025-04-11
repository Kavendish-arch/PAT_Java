import java.math.BigDecimal;

public class AutoBox {
    public static void main(String[] args) {
        Integer i = 10;
        Integer j = 10;
        System.out.println(i == j);
        System.out.println(i.equals(j));

        j = 128;
        i = 128;
        System.out.println(i == j);
        System.out.println(i.equals(j));

        /***
         * 在金融计算中，保证数据准确性有两种方案，一种使用 BigDecimal，一种将浮点数转换为整数 int 进行计算。
         *
         * 肯定不能使用 float 和 double 类型，它们无法避免浮点数运算中常见的精度问题，因为这些数据类型采用二进制浮点数来表示，无法准确地表示，例如 0.1。
         *
         *
         * BigDecimal num1 = new BigDecimal("0.1");
         * BigDecimal num2 = new BigDecimal("0.2");
         * BigDecimal sum = num1.add(num2);
         * System.out.println("Sum of 0.1 and 0.2 using BigDecimal: " + sum);  // 输出 0.3，精确计算
         * 在处理小额支付或计算时，通过转换为较小的货币单位（如分），这样不仅提高了运算速度，还保证了计算的准确性。
         *
         *
         * int priceInCents = 199;  // 商品价格199分
         * int quantity = 3;
         * int totalInCents = priceInCents * quantity;  // 计算总价
         * System.out.println("Total price in cents: " + totalInCents);  // 输出597分
         * Java 面试指南（付费）收录的字节跳动同学 7 Java 后端实习一面的原题：讲一下数据准确性高是怎么保证的？
         * GitHub 上标星 10000+ 的开源知识库《二哥的 Java 进阶之路》第一版 PDF 终于来了！包括 Java 基础语法、数组&字符串、OOP、集合框架、Java IO、异常处理、Java 新特性、网络编程、NIO、并发编程、JVM 等等，共计 32 万余字，500+张手绘图，可以说是通俗易懂、风趣幽默……详情戳：太赞了，GitHub 上标星 10000+ 的 Java 教程
         */
        BigDecimal num1 = new BigDecimal("0.1");
        BigDecimal num2 = new BigDecimal("0.2");
        BigDecimal sum = num1.add(num2);


        System.out.println("Sum of 0.1 and 0.2 using BigDecimal: " + sum);  // 输出 0.3，精确计算

        Double d1 = 0.1;
        Double d2 = 0.2;
        Double d3 = d1 + d2;
        double d5 = d1 + d2;

        Float f4 = (float)(d1+d2);
        System.out.println("Sum of 0.1 and 0.2 using Double: " + d3);
        System.out.println("Sum of 0.1 and 0.2 using Double: " + d5);
        System.out.println("Sum of 0.1 and 0.2 using Float: " + f4);
    }
}
