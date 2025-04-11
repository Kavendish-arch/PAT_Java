package com.itheima.method;

import java.security.SecureRandom;

public class MethodDemo1 {
    public static void main(String[] args) {
        // 目标：掌握方法的定义和调用。
        int sum = getSum(10, 20);
        System.out.println("和是：" + sum);

        System.out.println("----------------------------");

        int sum2 = getSum(100, 200);
        System.out.println("和是：" + sum2);

        printHelloWorld();

        System.out.println("----------------------------");

        System.out.println(getCode(4));
        System.out.println(getCode(5));
    }

    // 定义一个方法，求任意两个整数的和并返回
    public static int getSum(int a, int b) {
        return a + b;
    }

    // 需求：打印3行HelloWorld，不需要参数，也不需要返回值
    // 注意：如果方法没有返回结果，返回值类型必须声明成void.
    // 无参数，无返回值类型
    public static void printHelloWorld() {
        System.out.println("HelloWorld");
        System.out.println("HelloWorld");
        System.out.println("HelloWorld");
    }

    /**
     * 获取一个指定位数的验证码返回。
     *
     * @param len 验证码的位数
     * @return 生成的验证码字符串
     *
     * 潜在问题及风险
     * 随机数生成器初始化问题 当前代码使用 Math.random() 来生成随机数，这个方法在 Java 中是非加密安全的，并且其种子是基于当前时间的，容易被预测。
     * 如果验证码用于安全性较高的场景，这将是一个明显的安全隐患。
     * 异常处理缺失 虽然这段代码看起来不会抛出异常，但在更复杂的系统中，添加适当的异常处理总是好的实践，尤其是在调用外部库或依赖于某些资源时。
     * 代码可读性和维护性 代码虽然简单，但可以通过一些小的改进来增强其可读性和维护性。
     * 线程安全问题 如果该方法在多线程环境中被频繁调用，Math.random() 的行为可能不是线程安全的，尽管在当前上下文中这可能不是主要问题，但在并发场景下应予以考虑。
     * 优化方向
     * 使用加密安全的随机数生成器 使用 SecureRandom 类来代替 Math.random()，以提高生成验证码的安全性。
     * 增加注释说明 对于方法的功能、参数和返回值增加注释，提高代码的可读性。
     * 异常处理 尽管这里不太可能出现异常，但为将来可能的扩展打下基础，可以适当添加一些异常处理逻辑。
     */
    public static String getCode(int len) {
        if (len <= 0) {
            throw new IllegalArgumentException("验证码长度必须大于0");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder code = new StringBuilder(len);

        try {
            for (int i = 0; i < len; i++) {
                int num = random.nextInt(10);
                code.append(num);
            }
        } catch (Exception e) {
            // 这里可以记录日志或者进行其他错误处理
            System.err.println("生成验证码时发生错误: " + e.getMessage());
            return null; // 或者抛出异常
        }

        return code.toString();
    }
}

