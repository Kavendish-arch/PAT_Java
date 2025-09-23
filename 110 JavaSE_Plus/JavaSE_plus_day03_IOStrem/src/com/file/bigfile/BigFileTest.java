package com.file.bigfile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package com.file.bigfile
 * @className com.file.bigfile.BigFileTest
 * @date 2024/11/29 14:19
 * @description @todo
 */
public class BigFileTest {


    //测试文件分块方法
//        @Test
    public void testChunk() throws IOException {
        File sourceFile = new File("d:/develop/bigfile_test/nacos.mp4");
        String chunkPath = "d:/develop/bigfile_test/chunk/";
        File chunkFolder = new File(chunkPath);
        if (!chunkFolder.exists()) {
            chunkFolder.mkdirs();
        }
        //分块大小
        long chunkSize = 1024 * 1024 * 1;
        //分块数量
        long chunkNum = (long) Math.ceil(sourceFile.length() * 1.0 / chunkSize);
        System.out.println("分块总数：" + chunkNum);
        //缓冲区大小
        byte[] b = new byte[1024];
        //使用RandomAccessFile访问文件
        RandomAccessFile raf_read = new RandomAccessFile(sourceFile, "r");
        //分块
        for (int i = 0; i < chunkNum; i++) {
            //创建分块文件
            File file = new File(chunkPath + i);
            if (file.exists()) {
                file.delete();
            }
            boolean newFile = file.createNewFile();
            if (newFile) {
                //向分块文件中写数据
                RandomAccessFile raf_write = new RandomAccessFile(file, "rw");
                int len = -1;
                while ((len = raf_read.read(b)) != -1) {
                    raf_write.write(b, 0, len);
                    if (file.length() >= chunkSize) {
                        break;
                    }
                }
                raf_write.close();
                System.out.println("完成分块" + i);
            }

        }
        raf_read.close();

    }

    public static void main(String[] args) {

    }

}
