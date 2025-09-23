package mthread.n2.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT_Java
 * @package com.chen.mthread.n2.util
 * @className com.chen.mthread.n2.util.FileReader
 * @date 2025/4/20 14:51
 * @description @todo
 */

//@Slf4j(topic = "c.FileReader")
public class FileReader {
    /**
     * 读取指定文件内容并记录读取耗时（用于测试或基准测试）
     *
     * @param filename 需要读取的完整文件路径
     * @return void
     */
    public static void read(String filename) {
        // 从完整路径中提取文件名（去除目录部分）
        int idx = filename.lastIndexOf(File.separator);
        String shortName = filename.substring(idx + 1);

        try (FileInputStream in = new FileInputStream(filename)) {
            long start = System.currentTimeMillis();
//            log.debug("read [{}] start ...", shortName);
            System.out.println("start");
            // 持续读取文件内容（1KB缓冲区）
            byte[] buf = new byte[1024];
            int n = -1;
            do {
                n = in.read(buf);
            } while (n != -1);

            // 记录并输出文件读取耗时
            long end = System.currentTimeMillis();
//            log.debug("read [{}] end ... cost: {} ms", shortName, end - start);
            System.out.println("end");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

class Sleeper {
    public static void sleep(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleep(double i) {
        try {
            TimeUnit.MILLISECONDS.sleep((int) (i * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
