package com.file.demo6copy;

import java.io.*;

public class CopyDemo3 {
    public static void main(String[] args) {
        // 目标：使用字节流完成文件的复制操作。
        // 源文件：E:\resource\jt.jpg
        // 目标文件：D:\jt_new.jpg （复制过去的时候必须带文件名的，无法自动生成文件名。）
        copyFile("JavaSE_Plus/JavaSE_plus_day03_IOStrem/img2/des/02.png",
                "JavaSE_Plus/JavaSE_plus_day03_IOStrem/img2/des/02.png.bak");
    }

    // 复制文件

    /**
     * @param srcPath  源文件
     * @param destPath 目标文件
     */
    public static void copyFile(String srcPath, String destPath){
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);
        if (!srcFile.exists()) {
            System.out.println("源文件不存在，复制失败！");
            return;
        }
        try (
                InputStream fis = new FileInputStream(srcFile);
                OutputStream fos = new FileOutputStream(destFile);

        ) {
            // 2. 读取一个字节数组，写入一个字节数组  1024 + 1024 + 3
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("复制成功！");
            // 中间异常，抛出异常，fos和fis没有关闭。
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
