package com.bingfa;

import java.util.concurrent.TimeUnit;

/**
* @projectName PAT
* @package com.bingfa
* @className com.bingfa.CompanTest

* @author chenyingtao
* @date 2024/12/7 15:29
* @version 1.0
* @description @todo 
*/
public class CompanyTest {

    private static int count;

    // 如果方法不追加synchronized，会导致200次++操作结束后，结果不是200
    // 如果方法追加上了synchronized，200次++的操作结束后，结果就是预期的200了。
//    @SneakyThrows
    public static void increment() throws Exception {
        TimeUnit.MILLISECONDS.sleep(100);
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    increment();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    increment();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
