package com.chen.fixSum;

/**
* @projectName PAT
* @package com.chen.fixSum
* @className com.chen.fixSum.Main

* @author chenyingtao
* @date 2025/3/28 22:05
* @version 1.0
* @description @todo 
*/
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        char[][] nums = new char[201][201];
        int [][] prefixSum = new int [201][201];
        in.nextLine();
        String str = "";
        for (int i = 1; i <= n; i++) {
            str = in.nextLine();
            char[] lines = str.toCharArray();
            int j = 1;

            for (char c : lines) {
                // System.out.println(c);
                nums[i][j] = c;
                j++;
            }

            // System.out.println(str);
            // System.out.println(nums[i][j-1]);
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = nums[i][j] - '0' + prefixSum[i][j - 1] + prefixSum[i - 1][j]
                        -
                        prefixSum[i - 1][j - 1];
            }
        }
        // System.out.println(prefixSum[1][1]);
        // System.out.println(prefixSum[4][4]);
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                System.out.println(0);
            } else {
                int result = countBN(prefixSum, i, n);
                System.out.println(result);
            }
        }
        // int result = countBN(prefixSum, 4, n);
        // System.out.println(valid(prefixSum, 1, 1, 4));
    }

    // public static int countBN(char [][] nums, int i, int n) {

    //     int sum = 0;
    //     for (int row = 1; row <= n; row ++) {

    //         for (int col = 1; col < n; col ++) {
    //             if ( row + i <= n && col + i <= n) {

    //                 if (valid(nums, row, row + i, col, col + i)) {
    //                     // System.out.println(row + ":" + col + " " + i);
    //                     sum ++;
    //                 }
    //             }
    //         }
    //     }


    //     return sum;
    // }

    public static int countBN(int [][] nums, int size, int n) {

        int sum = 0;
        for (int row = 1; row <= n - size + 1; row ++) {

            for (int col = 1; col <= n - size + 1; col ++) {

                if (valid(nums, row, col, size)) {

                    // System.out.println(row + ":" + col + " " + size);
                    sum ++;
                }
            }
        }


        return sum;
    }


    // public static boolean valid(char [][] nums,
    //                             int row_s, int row_e,
    //                             int col_s, int col_e) {

    //     int count1 = 0;
    //     int count0 = 0;
    //     for (int i = row_s; i < row_e; i++) {
    //         for (int j = col_s; j < col_e; j++) {
    //             if (nums[i][j] == '0') {
    //                 count0 ++;
    //             }
    //             if (nums[i][j] == '1') {
    //                 count1 ++;
    //             }

    //         }
    //     }
    //     return count0 == count1;
    // }

    public static boolean valid(int[][] prefixSum, int row, int col, int size) {
        int total = prefixSum[row + size - 1][col + size - 1];
        int topleft = prefixSum[row - 1][col - 1];
        int top = prefixSum[row - 1][col + size - 1];
        int left = prefixSum[row + size - 1][col - 1];

        int count1 = total + topleft - top - left;
        int count0 = (size * size) - count1;
        return count0 == count1;
    }
}