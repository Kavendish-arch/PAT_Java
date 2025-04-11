public class Main {
    /**
     * 主函数入口
     * 该程序运行时将打印"Hello world!"到控制台
     * @param args 命令行参数，本程序不使用该参数
     */
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    //写一个函数，输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

    /**
     * 计算一个整数的二进制表示中1的个数
     *
     * @param n 要计算的整数
     * @return 返回该整数二进制表示中1的个数
     */
    public static int NumberOf1(int n) {
        // 初始化计数器为0，用于统计1的个数
        int count = 0;
        // 当n不为0时，继续循环
        while (n != 0) {
            // 每次循环，计数器加1，表示找到了一个1
            count++;
            // 通过n与(n-1)的与运算，将n的二进制表示中最右边的一个1变为0
            n = n & (n - 1);
        }
        // 返回计数器的值，即n的二进制表示中1的个数
        return count;
    }

    //写一个函数解决背包问题
}