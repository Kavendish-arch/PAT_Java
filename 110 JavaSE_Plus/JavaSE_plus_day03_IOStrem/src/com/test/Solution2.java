package com.test;

import java.io.*;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package com.test
 * @className com.test.Solution2
 * @date 2024/11/17 17:57
 * @description windows操作系统中可以进行文件夹的剪切操作, 比如把D:\\from\\day11文件夹,剪切到E:\\to文件夹下,但是java没有提供剪切文件夹的方法。 请编写程序从键盘接收两个文件夹路径,把其中一个文件夹(包含内容)剪切到另一个文件夹中。效果如下图：
 */
public class Solution2 {
    public static void main(String[] args) throws FileNotFoundException {
        moveFile("JavaSE_Plus/JavaSE_plus_day03_IOStrem/img/des/des/02.png",
                "JavaSE_Plus/JavaSE_plus_day03_IOStrem/img/des/des2/02.png");
    }

    /**
     * @param srcPath
     * @param destPath
     */
    public static void moveFile(String srcPath, String destPath) throws FileNotFoundException {
        File srcFile = new File(srcPath);
        File destFile = new File(destPath);
        moveFile(srcFile, destFile);
    }

    public static void moveFile(File srcPath, File destPath) throws FileNotFoundException {
        if (!srcPath.exists()) {
            System.out.println("源文件不存在");
            throw new FileNotFoundException("文件找不到");
//            System.out.println("源文件不存在");

        }

        try (
                InputStream bis = new BufferedInputStream(new FileInputStream(srcPath));
                OutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath));
        ) {
            byte[] buffer = new byte[1024 * 8];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

            System.out.println("文件删除中" + srcPath.delete());
            System.out.println("文件剪切成功");
        } catch (Exception e) {

        }
    }
}
