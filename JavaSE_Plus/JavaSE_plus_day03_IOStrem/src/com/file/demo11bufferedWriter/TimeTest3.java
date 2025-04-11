package com.file.demo11bufferedWriter;

import java.io.*;

public class TimeTest3 {
    private static final String SRC_FILE = "E:\\本地磁盘D\\Captures\\原神 2023-11-02 21-31-22.mp4";
    private static final String DEST_FILE = "E:\\本地磁盘D\\Captures\\原神 2024-11-17 11-17-57.mp4";
    private static final int SIZE = 8;
    public static void main(String[] args) {
        // 目标：缓冲流，低级流的性能分析。
        /**
         * 测试用例：
         分别使用原始的字节流，以及字节缓冲流复制一个很大视频。
         测试步骤：

         使用低级的字节流按照一个一个字节的形式复制文件。
         使用低级的字节流按照字节数组的形式复制文件。

         使用高级的缓冲字节流按照一个一个字节的形式复制文件。
         使用高级的缓冲字节流按照字节数组的形式复制文件。

         */
        //使用低级的字节流按照一个一个字节的形式复制文件: 非常的慢，简直让人无法忍受，直接淘汰，禁止使用！！
//        copyFile1();
        //使用低级的字节流按照字节数组的形式复制文件: 是比较慢的，还可以接受。
        copyFile2();
        //使用高级的缓冲字节流按照一个一个字节的形式复制文件：虽然是高级管道，但一个一个字节的复制还是太慢了，无法忍受，直接淘汰！
//        copyFile3();
        //使用高级的缓冲字节流按照字节数组的形式复制文件: 非常快！推荐使用！
        copyFile4();
    }

    //使用高级的缓冲字节流按照字节数组的形式复制文件。
    private static void copyFile4() {
        // 拿系统当前时间 时间毫秒值，从1970-1-1 00:00:00开始走到此刻的总毫秒值  1s = 1000ms
        long start = System.currentTimeMillis();
        try (
                InputStream fis = new FileInputStream(SRC_FILE);
                InputStream bis = new BufferedInputStream(fis);
                OutputStream fos = new FileOutputStream(DEST_FILE + "4.avi");
                OutputStream bos = new BufferedOutputStream(fos);
        ) {
            byte[] bytes = new byte[1024 * SIZE];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("高级的缓冲字节流按照字节数组的形式复制文件，耗时：" + (end - start) / 1000.0 + "s");
    }

    //使用高级的缓冲字节流按照一个一个字节的形式复制文件。
    private static void copyFile3() {
        long start = System.currentTimeMillis();
        try (
//                InputStream fis = new FileInputStream(SRC_FILE);
                InputStream bis = new BufferedInputStream(new FileInputStream(SRC_FILE));
                OutputStream fos = new FileOutputStream(DEST_FILE + "3.avi");
                OutputStream bos = new BufferedOutputStream(fos);
        ) {
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("高级的缓冲字节流按照一个一个字节的形式复制文件，耗时：" + (end - start) / 1000.0 + "s");
    }

    //使用低级的字节流按照字节数组的形式复制文件。
    private static void copyFile2() {
        long start = System.currentTimeMillis();
        try (
                InputStream fis = new FileInputStream(SRC_FILE);
                OutputStream fos = new FileOutputStream(DEST_FILE + "2.avi");
        ) {
            byte[] bytes = new byte[1024 * SIZE];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("低级的字节流按照字节数组的形式复制文件，耗时：" + (end - start) / 1000.0 + "s");
    }

    //使用低级的字节流按照一个一个字节的形式复制文件。
    public static void copyFile1() {
        // 拿系统当前时间
        long start = System.currentTimeMillis(); // 此刻时间毫秒值： 从1970-1-1 00:00:00开始走到此刻的总毫秒值  1s = 1000ms
        try (
                InputStream fis = new FileInputStream(SRC_FILE);
                OutputStream fos = new FileOutputStream(DEST_FILE + "1.avi");
        ) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();  // 此刻时间毫秒值： 从1970-1-1 00:00:00开始走到此刻的总毫秒值  1s = 1000ms
        System.out.println("低级字节流按照一个一个字节的形式复制文件，耗时：" + (end - start) / 1000.0 + "s");
    }
}
