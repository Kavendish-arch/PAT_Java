package com.file.demo13_printstream;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataStreamDemo3 {
    public static void main(String[] args) {
        // 目标：特殊数据流的使用。
        try (
                DataInputStream dis = new DataInputStream(new FileInputStream("JavaSE_Plus/JavaSE_plus_day03_IOStrem/txt/data.txt"));
        ) {
            System.out.println(dis.readByte());
            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
