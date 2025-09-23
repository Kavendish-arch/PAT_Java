package com.chen.dpattern.unit4.solution;

import java.util.Scanner;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package solution
 * @className solution.Main2
 * @date 2025/4/9 20:21
 * @description @todo
 */
public class Main2 {
    /**
     * 快速幂
     * 算法解析
     * 快速幂原理：
     * 将指数b转换为二进制形式，通过位运算分解指数
     * 例如计算3^13，分解为3^(8+4+1) = 3^8 * 3^4 * 3^1
     * 时间复杂度从O(n)优化到O(log n)
     * 取模优化：
     * 利用公式 (a * b) % p = [(a % p) * (b % p)] % p
     * 每次乘法运算后立即取模，防止数值溢出
     * 边界处理：
     * 当p=1时，任何数mod1都为0
     * 当b=0时，根据题意a>0，返回1%p（兼容p=1的情况）
     * 复杂度分析
     * 时间复杂度：O(log b)，通过指数位的逐次右移处理
     * 空间复杂度：O(1)，仅需常数级别存储空间
     */
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            long a = scanner.nextLong();
//            long b = scanner.nextLong();
//            long p = scanner.nextLong();
//            System.out.println(powMod(a, b, p));
//        }

        System.out.println(binpow(2, 10));
    }

    private static long powMod(long a, long b, long p) {
        if (a == 0) return 0;
        if (b == 0) return 1 % p;

        long result = 1;
        a = a % p; // 初始取模减少计算量

        while (b > 0) {
            if ((b & 1) == 1) { // 当前二进制位为1
                result = (result * a) % p;
            }
            a = (a * a) % p; // 底数平方
            b >>= 1;         // 指数右移
        }
        return result;
    }

    public static long binpow(long a, long b) {
        if (b == 0) return 1;
        long res = binpow(a, b / 2);
        if (b % 2 == 0) {
            return res * res;
        } else {
            return res * res * a;
        }
    }

    public static long dieBinPow(long a, long b) {
        if (b == 0) return 1;
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a;
            }
            a = a * a;
            b = b >> 1;
        }
        return res;
    }
}
