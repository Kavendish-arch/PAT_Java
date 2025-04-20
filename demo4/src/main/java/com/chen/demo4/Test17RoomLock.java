package com.chen.demo4;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT_Java
 * @package com.chen.demo4
 * @className com.chen.demo4.Test17RoomLock
 * @date 2025/4/20 21:02
 * @description @todo
 */
public class Test17RoomLock {
    public static void main(String[] args) {
        RoomLock roomLock = new RoomLock();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++)
                roomLock.increment();
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++)
                roomLock.decrement();
        }, "t2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(roomLock.getCount());
    }

}

class RoomLock {
    private int count = 0;

//    public void increment() {
//        synchronized (this) {
//            count++;
//        }
//    }

    public synchronized void increment() {
//        synchronized (this) {
        count++;
    }

    public void decrement() {
        synchronized (this) {
            count--;
        }
    }

    public int getCount() {
        synchronized (this) {
            return count;
        }
    }

    public static void test(){
        synchronized (RoomLock.class){
            System.out.println("test");
        }
    }

    public static synchronized void test2(){
        System.out.println("test2");
    }
}