package com.chen.字符串问题;

public class solution2 {

    public static void main(String[] args) {
        String S = "abc";
        int l = 2;
        int r = 5;
        System.out.println(getSubString(S, l, r));
    }

    public static String getSubString(String S, int l, int r) {
        // 构建字符串T
        l = l - 1;
        StringBuilder T = new StringBuilder();

        // 循环，直到T的长度至少为r
        while (S.length() > 0) {
            T.append(S); // 将S拼接到T后面
            S = S.substring(1); // 删除S的第一个字符
        }

        // 返回T的第l个字符到第r个字符之间的子串
        return T.substring(l, r);
    }
}
