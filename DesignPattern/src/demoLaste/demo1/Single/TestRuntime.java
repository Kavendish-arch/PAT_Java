package demoLaste.demo1.Single;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package demoLaste.demo1.Single
 * @className demoLaste.demo1.Single.TestRuntime
 * @date 2024/10/22 16:54
 * @description JDK案例 单例模式
 */
public class TestRuntime {

    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();

        System.out.println(runtime.totalMemory() / 1024 / 1024);
//        runtime.totalMemory();

        // 命令参数
        Process process = runtime.exec("ipconfig");
        InputStream is = process.getInputStream();
        byte[] arr = new byte[1024 * 1024 * 1000];
        int len = is.read(arr);

        System.out.println(new String(arr, 0, len, "GBK"));
    }
}
