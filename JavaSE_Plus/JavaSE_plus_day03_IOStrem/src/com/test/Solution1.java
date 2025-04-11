package com.test;

import java.io.*;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package com.test
 * @className com.test.Solution1
 * @date 2024/11/17 17:32
 * @description windows操作系统中可以复制文件夹, 比如把D:\\from\\day11文件夹,复制到E:\\to\\day11文件夹下。但是java没有提供直接复制文件夹的方法.请编写程序从键盘接收两个文件夹路径,把其中一个文件夹中(包含内容)拷贝到另一个文件夹中。效果如下图：
 */
public class Solution1 {
    public static void main(String[] args) throws Exception {
        //
        long start = System.currentTimeMillis();

//        copyFolder("JavaSE_Plus/JavaSE_plus_day03_IOStrem/txt",
//                "JavaSE_Plus/");
        copyFile("JavaSE_Plus/JavaSE_plus_day03_IOStrem/txt/ps.txt",
                "JavaSE_Plus/JavaSE_plus_day03_IOStrem/txt3/");
        long end = System.currentTimeMillis();
        System.out.println("复制文件夹耗时：" + (end - start) / 1000.0 + "s");
    }

    public static void copyFolder(String srcPath, String destPath) throws Exception {
        // 创建源和目标
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);
        copyFolder(srcFile, destFile);
    }

    /**
     * @param srcDirFile  源文件夹
     * @param destDirFile 目标文件夹
     * @throws FileNotFoundException
     */
    public static void copyFolder(File srcDirFile, File destDirFile) throws Exception {

        if (!srcDirFile.exists()) {
            throw new FileNotFoundException("文件找不到");
        }
        File newDir = new File(destDirFile, srcDirFile.getName());

        if (!newDir.exists()) {
            System.out.println("目标文件夹不存在，创建目标文件夹");
            newDir.mkdirs();
        }
        File[] files = srcDirFile.listFiles();
        if (files == null || files.length == 0) {
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
//                System.out.println("复制文件：" + file.getAbsoluteFile() + "到 " + destDirFile.getAbsoluteFile());
                copyFile(file, newDir);
            } else if (file.isDirectory()) {
//                System.out.println("复制文件夹：" + file.getAbsoluteFile() + "到 " + destDirFile.getAbsoluteFile());
//                File destDir = new File(destDirFile.getAbsoluteFile()+ "/" + file.getName());
                copyFolder(file, newDir);
            }
        }

    }

    /**
     * @param srcPath  源文件 文件
     * @param destPath 目标文件 文件 目录
     */
    public static void copyFile(String srcPath, String destPath) throws Exception {

        File srcFile = new File(srcPath);
        File destFile = new File(destPath);
        //
        copyFile(srcFile, destFile);
    }

    /**
     * 定义复制文件到文件的方法
     *
     * @param srcPath  文件 *.txt
     * @param dir *.txt
     */
    public static void copyFile(File srcPath, File dir) throws Exception {
        // 定义路径
        // 1. 判断源文件是否存在
        if (!srcPath.exists()) {
            throw new FileNotFoundException("文件找不到");
        }

        File destPath = dir;
        if (dir.getAbsolutePath().endsWith("/"))
        {
            destPath = new File(dir.getParentFile().getAbsolutePath(), srcPath.getName());
        }

        try (
                // 将文件A复制到文件B上
                // 2. 创建一个文件字节输入流管道与源文件接通
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcPath));
                // 3. 创建一个缓冲你文件字节输出流管道与目标文件接通
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath));
        ) {
            // 复制文件
            byte[] buffer = new byte[1024 * 8];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
