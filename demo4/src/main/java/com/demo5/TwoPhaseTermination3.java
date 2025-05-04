package com.demo5;

/**
 * 
 * 利用 volatile 关键字实现线程间通信
 * 
 * 防止重复创建
 */
public class TwoPhaseTermination3 {
    private Thread monitorThread;
    private volatile boolean stop = false;
    private volatile boolean started = false;

    public void start() {
        synchronized (this) {
            if (started) {
                return;
            }
            started = true;
        }
        monitorThread = new Thread(() -> {
            while (true) {
                // Thread current = Thread.currentThread();
                // 检查是否中断
                if (stop) {
                    System.out.println(System.currentTimeMillis() + " 料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis() + " 执行监控记录");
                } catch (InterruptedException e) {
                }

            }
        }, "monitor");

        monitorThread.start();
        // }
    }

    public void stop() {
        System.out.println(System.currentTimeMillis() + " main 决定打断");
        stop = true;
        // monitorThread.interrupt();
    }

    public static void main(String[] args) {
        TwoPhaseTermination2 tpt = new TwoPhaseTermination2();
        tpt.start();

        tpt.stop();
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tpt.stop();
    }
}
