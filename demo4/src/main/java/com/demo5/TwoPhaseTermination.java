package com.demo5;

public class TwoPhaseTermination {
    private Thread monitorThread;

    public void start()
    {
        monitorThread = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                // 检查是否中断
                if (current.isInterrupted()) {
                    System.out.println("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    System.out.println("执行监控记录");
                } catch (InterruptedException e) {
                    // 因为sleep 出现异常会清除打断标记
                    current.interrupt();
                }

            }
        }, "monitor");
        
        monitorThread.start();
    }

    public void stop()
    {
        System.out.println("main 决定打断");
        monitorThread.interrupt();
    }

    public static void main(String[] args) {
        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tpt.stop();
    }
}
