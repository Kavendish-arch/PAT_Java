package com.chen.demo4;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT_Java
 * @package com.chen.demo4
 * @className com.chen.demo4.Test17Que
 * @date 2025/4/20 21:07
 * @description @todo
 */
public class Test17Que4 {
    public static void main(String[] args) {
        Number4 number = new Number4();
        Number4 number2 = new Number4();
        new Thread(() -> {
            try {
                number.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(number2::b).start();

    }
}

class Number4 {
    public synchronized void a() throws InterruptedException {
        Thread.sleep(1);
        System.out.println(1);
    }

    public synchronized void b() {
        System.out.println(2);
    }
}
