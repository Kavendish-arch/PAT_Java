package com.file.demo13_printstream;

import java.io.PrintStream;

public class PrintStreamDemo1 {
    public static void main(String[] args) {
        // 目标：打印流的使用。
        try (
               PrintStream ps = new PrintStream("JavaSE_Plus/JavaSE_plus_day03_IOStrem/ps.txt");
//                PrintStream ps = new PrintStream(new FileOutputStream("JavaSE_Plus/JavaSE_plus_day03_IOStrem/txt/ps.txt", true));
//                PrintWriter ps = new PrintWriter("JavaSE_Plus/JavaSE_plus_day03_IOStrem/txt");
        ) {
            ps.println(97);
            ps.println('a');
            ps.println("黑马");
            ps.println("黑马");
            ps.println(true);
            ps.println(99.9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
