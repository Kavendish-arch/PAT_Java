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
public class Test17Que {
    public static void main(String[] args) {
        Number number = new Number();
        new Thread(() -> {
            try {
                number.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(number::b).start();

    }
}

class Number {
    public synchronized void a() throws InterruptedException {
//        Thread.sleep(1000);
        System.out.println(1);
    }

    public synchronized void b() {
        System.out.println(2);
    }
}

class Number2 {
    public synchronized void a() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(1);
    }

    public synchronized void b() {
        System.out.println(2);
    }
}

class Number3 {
    public void a() throws InterruptedException {
        synchronized (this) {
            Thread.sleep(1000);
            System.out.println(1);
        }
    }

    public synchronized void b() {
        System.out.println(2);
    }

    public void c() {
        System.out.println(3);
    }
}