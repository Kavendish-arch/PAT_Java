package com.file.demo14_commonsio;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class CommonsIoDemo1 {
    public static void main(String[] args) throws Exception {
        // 目标：IO框架
//        FileUtils.copyFile(
//                new File("day03-file-io\\src\\csb_out.txt"),
//                new File("day03-file-io\\src\\csb_out2.txt"));

        //JDK 7提供的
//        Files.copy(Path.of("day03-file-io\\src\\csb_out.txt"), Path.of("day03-file-io\\src\\csb_out3.txt"));


        FileUtils.deleteDirectory(new File("E:\\本地磁盘D\\Captures\\新建文件夹"));
        FileUtils.delete(new File("E:\\本地磁盘D\\Captures\\原神 2024-11-17 11-17-57.mp41.avi"));
    }
}
