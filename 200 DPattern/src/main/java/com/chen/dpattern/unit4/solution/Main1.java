package com.chen.dpattern.unit4.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @projectName DesignPattern
 * @package solution
 * @className solution.Main1

 * @author chenyingtao
 * @date 2025/4/9 20:16
 * @version 1.0
 * @description @todo
 */
import java.io.*;
import java.util.StringTokenizer;

public class Main1 {
    /**
     * 小美有一个长度为n 的数组 a1,a2,..,an ，他可以对数组进行如下操作:
     * ● 删除第一个元素 a1，同时数组的长度减一，花费为 x。
     * ● 删除整个数组，花费为 k*MEX(a)(其中 MEX(a) 表示a中未出现过的最小非负整数。例如 [0,1,2,4]的 MEX为3)。
     * 小美想知道将a数组全部清空的最小代价是多少，请你帮帮他吧。
     * 解法思路
     * 要解决这个问题，我们需要在两种删除数组的操作中找到最小代价。关键点在于动态计算每个子数组的 MEX（最小未出现的非负整数），并比较所有可能的删除策略。
     * 关键步骤分析
     * MEX 预处理
     * 从右到左遍历数组，维护当前子数组的元素集合，并动态计算其 MEX。
     * 使用 HashSet 记录元素是否存在，并逐步更新当前子数组的 MEX 值。
     * 动态计算最小代价
     * 对每个可能的删除位置 i（表示删除前 i 个元素后执行整体删除），计算总代价：
     * i * x（逐个删除代价） + k * MEX（剩余子数组的 MEX）。
     * 遍历所有 i（包括 i=0 和 i=n 的情况），找到最小总代价。
     * Java 实现代码
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int n, k, x;
        n = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }


        // 预处理 mex_suffix 数组
        /**
         * 6 3 3
         * 4 5 2 3 1 0
         * 0 1 2 3 4 5
         * 6 4 4 2 2 1
         */
        int[] mexSuffix = new int[n + 1];
        mexSuffix[n] = 0;
        Set<Integer> set = new HashSet<>();
        int mex = 0;
        for (int i = n - 1; i >= 0; i--) {
            set.add(nums[i]);
            while (set.contains(mex)) {
                mex++;
            }
            // 0 - i 的 MEX
            mexSuffix[i] = mex;
        }

        for(int i : mexSuffix){
            System.out.println(i);
        }
        // 计算所有可能的最小代价
        // 6 4 4 2 2 1

        long minCost = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            long cost;
            // i = 0 时，删除前 i 个元素后执行整体删除，i * x + k * MEX
            // 删除一个 花费 x
            // 删除全部 k * mexS[i]
            if (i < n) {
                cost = (long) i * x + (long) k * mexSuffix[i];
            } else {
                // i = n;
                // 1 个一个删
                cost = (long) n * x;
            }
            minCost = Math.min(minCost, cost);
        }
        System.out.println(minCost);
    }
}
