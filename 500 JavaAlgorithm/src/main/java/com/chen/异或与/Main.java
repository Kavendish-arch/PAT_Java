package com.chen.异或与;//package 异或与;

import java.util.Scanner;

/**
 * 游游拿到了一个长度为 n 的数组 a，下标从1开始，q次询问(OP,l,r)。op = 1，计算 a& al+1|ai+2& a1+3|ai+4...a, 的值。以& 开始，交替 &|。op=2，计算 a|al+1& al+2|ai+3 & a+4...a, 的值。以|开始，交替|&。例如:询问(1,3,9)，计算 aз&a¡|as &a6|a7&a8|ag。询问(2,3,9)，计算asa&asas&a7ag &ag
 * 本题的 & 和|不区分优先级，从左往右计算。
 * alb表示a按位或b(按位或运算符“是双目运算符。其功能是参与运算的两数各对应的进位相或。只要对应的两个二进位有一个为1时，结果位就为1)。
 * a&b表示a按位与b(按位与运算符“&”是双目运算符。其功能是参与运算的两数各对应的二进位相与。只要对应的两个二进位两个都为1时，结果位就为1)。
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int len = in.nextInt();
        int ncase = in.nextInt();

        int[] arr = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < ncase; i++) {
            int op = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int result = query(arr, op, x, y);
            System.out.println(result);
        }
    }

    public static int query(int[] a, int op, int l, int r) {
        // 初始化结果为 a[l-1]，因为数组的下标从 0 开始
        int result = a[l];
        // 初始化运算符，true 表示 &，false 表示 |
        boolean isAnd = (op == 1);

        // 遍历 l 到 r-1 的数组元素
        for (int i = l; i <= r; i++) {
            if (isAnd) {
                result &= a[i];
            } else {
                result |= a[i];
            }
            // 交替运算符
            isAnd = !isAnd;
        }

        return result;
    }

    public static int sultion(int[] arr, int op, int x, int y) {
        int result = arr[x];
        boolean isAnd = (op==1);
        for(int i = x; i <= y; i++)
        {
            if(isAnd)
            {
                result &= arr[i];
            }
            else
            {
                result |= arr[i];
            }
            isAnd = !isAnd;
        }
        return result;
    }


}
