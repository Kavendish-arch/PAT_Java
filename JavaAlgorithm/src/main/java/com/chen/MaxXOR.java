package com.chen;
/**
 * 小红有一个正整数x ，你需要找一个不大于k的正整数y，使得 x xor y最大，求这个y。
 * 注:ror 指按位异或。
 * 异或运算，相同为0,不同为1
 */
import java.util.Scanner;
import java.lang.Integer;
public class MaxXOR {

    public static void main(String[] args) {
/*        int x = 123; // 示例中的x值，你可以根据需要修改这个值
        int k = 1000; // 示例中的k值，你可以根据需要修改这个值
        int y = findMaxXorY(x, k);*/
//        System.out.println("最大的异或值对应的y是: " + y);

        System.out.println(findMaxXorY(3,2));
        System.out.println(findMaxXorY(5,4));
        System.out.println(findMaxXorY(10,18));
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int k = scanner.nextInt();
            int y = findMaxXorY(x, k);
            System.out.println(y);
        }
    }

    private static int findMaxXorY(int x, int k) {
        int maxY = 0;
        int maxXor = 0;
        int y = 0;
        for(int i = Integer.numberOfLeadingZeros(k); i < 32; i++){
            int xBit = (x >> i) & 1;
            int desiredBit = 1 - xBit;
            int temp = y | (desiredBit << i);
            int mask = (i << i) - 1;
            temp |= (mask & (~x));
            if (temp <= k){
                y = temp;
            } else{
                y |= ((k >> i) & 1) << i;
            }
        }
        return y;
//        for (int y = k; y > 0; y--) {
//            int currentXor = x ^ y;
//            if (currentXor > maxXor) {
//                maxXor = currentXor;
//                maxY = y;
//            }
//        }
//
//        return maxY;
    }


}
