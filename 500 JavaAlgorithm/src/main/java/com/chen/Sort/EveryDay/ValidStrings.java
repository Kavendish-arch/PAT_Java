package com.chen.Sort.EveryDay;

//import trans.Int2Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName 排序
 * @package EveryDay
 * @className EveryDay.ValidStrings
 * @date 2024/10/29 19:26
 * @description 3211. 生成不含相邻零的二进制字符串
 * 提示 给你一个正整数 n。
 * 如果一个二进制字符串 x 的所有长度为 2 的子字符串中包含至少一个 "1"，
 * 则称 x 是一个 有效 字符串。  返回所有长度为 n 的有效字符串，可以以任意顺序排列。
 */
public class ValidStrings {
    /**
     * 暴力解法
     *
     * n位
     * 从 0 -> 111111111111 依次尝试
     * 难点：
     * 1. 十进制转二进制，补零
     * 2. 二进制串校验， 相邻两个数组必须有一个1
     * @param n
     * @return
     */
    public List<String> validStrings(int n) {
        int start = 0;
        int end =  (1 << n);
        ArrayList<String> list = new ArrayList<>();
        for(int i = start; i < end; i++)
        {
            String s = Int2Binary(i, n);
            if(validString(s))
            {
                list.add(s);
            }
        }
        return list;
    }
    public String Int2Binary(int n, int length)
    {
        StringBuilder sb = new StringBuilder();
        while(n != 0)
        {
            sb.append(n % 2);
            n /= 2;
        }
        while (sb.length() < length)
            sb.append(0);
        sb.reverse();
        return sb.toString();
    }
    public static boolean validString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '0' && chars[i + 1] == '0') {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ValidStrings validStrings = new ValidStrings();
        List<String> s = validStrings.validStrings(3);
        System.out.println(s);
        int n = 8;
        System.out.println(validStrings.Int2Binary(n, 5));

    }
}
