package com.file.demo11bufferedWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package com.file.demo11bufferedWriter
 * @className com.file.demo11bufferedWriter.BufferDemoCSB
 * @date 2024/11/17 16:20
 * @description 测试用例， 出师表
 */
public class BufferDemoCSB {
    public static void main(String[] args) {
        // 完成出师表文件复制
        copyFile("JavaSE_Plus/JavaSE_plus_day03_IOStrem/txt/csb.txt",
                "JavaSE_Plus/JavaSE_plus_day03_IOStrem/txt/csb.bak.txt");
    }

    public static void copyFile(String scrPath, String descPath){
        try (
                BufferedReader fr = new BufferedReader(new FileReader(scrPath));
                BufferedWriter bw = new BufferedWriter(new FileWriter(descPath));
                ){
            List<String> data = new ArrayList<>();

            String line;
            while ((line = fr.readLine()) != null){
                data.add(line);
            }
            Collections.sort(data);
            System.out.println(data);

            for(String line1 : data){
                bw.write(line1);
                bw.newLine();
            }
            System.out.println("处理完毕！");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
