package com.file.demo3charset;

import java.util.Arrays;

public class CharSetDemo1 {
    public static void main(String[] args) throws Exception {
        // 目标：写程序实现字符编码和解码
        // 1、编码
        // Ascii码 8位，有效七位 一个字节一个字符
        // GBk 码 16位，两个字节存储
        // GBK 码 16位，两个字节存储，首位1 有效位15位，
        // gbk 兼容ASCII 码，但是有乱码。

        // UTF-8 编码 Unicode编码 统一码
        /**
         * UTF-8 编码规则：
         * UTF-32 4字节  UTF-16 2字节  UTF-8 1字节
         */
        // byte[] bytes = name.getBytes(); // 平台的UTF-8编码的。
        // 编码   name.getBytes("GBK");
        // 解码   new String(bytes, "GBK");


        String name = "我爱你中国abc666";
        byte[] bytes = name.getBytes("GBK"); // 指定GBK进行编码。
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        byte[] utf8Bytes = name.getBytes("UTF-8");

        // 2、解码
//         String name2 = new String(bytes); // 平台的UTF-8解码的。
        System.out.println(new String(bytes));
        System.out.println(new String(utf8Bytes));
//        String name2 = new String(bytes, "GBK");// 指定GBK进行解码
        System.out.println(new String(bytes, "GBK"));
    }
}
