package com.file;

import java.io.File;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package com.file
 * @className com.file.FileDemo1
 * @date 2024/11/17 13:29
 * @description 创建对象代表文件
 */
public class FileDemo1 {
    public static void main(String[] args) {
        // 目标：创建对象代表文件。
        // 1. 创建对象代表文件，获取文件的信息
        File f1 = new File("D:\\Users\\chenyingtao\\Source\\Repos\\PAT\\JavaSE_Plus\\JavaSE_plus_day03_IOStrem\\img\\02.png");
        System.out.println(f1.getName());
        System.out.println(f1.length());
        System.out.println(f1.getAbsolutePath());
        System.out.println(f1.getParent());
        System.out.println(f1.exists());
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
        System.out.println("==========================");
        // 2. 使用相对路径定位文件对象
        // 相对路径是相对于当前项目的根目录来说的。默认Idea工程下的目录

        File f2 = new File("JavaSE_Plus\\JavaSE_plus_day03_IOStrem\\src\\Delilei.txt");
        System.out.println(f2.exists());
        System.out.println(f2.getName());
        System.out.println(f2.length());
        System.out.println(f2.getAbsolutePath());
        System.out.println(f2.getParent());
        System.out.println(f2.isDirectory());
        System.out.println(f2.isFile());
        System.out.println("==========================");
        // 3. 创建文件
        System.out.println("创建文件");
        File f3 = new File("Delei.txt");
        try {
            System.out.println(f3.exists());
            System.out.println(f3.createNewFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 4. 创建文件夹路径
        System.out.println("创建文件夹");
        File f4 = new File("JavaSE_Plus\\JavaSE_plus_day03_IOStrem\\src\\com\\file\\test");
        System.out.println(f4.exists());
        System.out.println(f4.mkdir());
        // 5. 创建多级文件夹路径
        System.out.println("创建多级文件夹");
        File f5 = new File("JavaSE_Plus\\JavaSE_plus_day03_IOStrem\\src\\com\\file\\test2\\test3");
        System.out.println(f5.exists());
        System.out.println(f5.mkdirs());

        System.out.println("==========================");
        File f6 = new File("JavaSE_Plus\\JavaSE_plus_day03_IOStrem\\src\\com\\file\\test");
        System.out.println(f6.exists());
        System.out.println(f6.delete());

        File f7 = new File("JavaSE_Plus\\JavaSE_plus_day03_IOStrem\\src\\com\\file\\test2\\test3");
        System.out.println(f7.exists());
        System.out.println(f7.delete());
        System.out.println("====================");
        // 8. 获得文件下所有一级文件名称
        File f9 = new File("JavaSE_Plus\\JavaSE_plus_day03_IOStrem\\src\\com\\file");
        String[] names = f9.list();
        assert names != null;
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("====================");
        File[] files = f9.listFiles();
        assert files != null;
        for (File file : files) {
//            System.out.println(file.getName());
            System.out.println(file.getAbsoluteFile());
        }
        /**
         * 使用listFiles方法时的注意事项:
        当主调是文件，或者路径不存在时，返回null
        当主调是空文件夹时，返回一个长度为0的数组
        当主调是一个有内容的文件夹时，将里面所有一级文件和文件夹的路径放在File数组中返回
         当主调是一个文件夹，且里面有隐藏文件时，将里面所有文件和文件夹的路径放在File数组中返回，包含隐藏文件
         当主调是一个文件夹，但是没有权限访问该文件夹时，返回null
         */
    }
}
