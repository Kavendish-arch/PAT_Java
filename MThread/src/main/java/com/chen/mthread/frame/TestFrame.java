package com.chen.mthread.frame;

/**
* @projectName PAT_Java
* @package com.chen.mthread.frame
* @className com.chen.mthread.frame.TestFrame

* @author chenyingtao
* @date 2025/4/20 15:51
* @version 1.0
* @description @todo 
*/
public class TestFrame {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            test1(10);
        });
        t1.setName("thread1");
        t1.start();
        test1(10);
    }

    public static void test1(int x) {
        int y = x + 1;
        Object m = test2();
        System.out.println(m);
    }

    public static Object test2() {
        Object m = new Object();
        return m;
    }
}
