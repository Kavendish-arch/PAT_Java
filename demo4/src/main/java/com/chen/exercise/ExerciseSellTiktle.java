package com.chen.exercise;

import java.util.*;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT_Java
 * @package com.chen.exercise
 * @className com.chen.exercise.ExerciseSellTiktle
 * @date 2025/4/20 21:54
 * @description @todo
 */
public class ExerciseSellTiktle {
    public static void main(String[] args) {
        int num = 1000;
        //模拟多人买票
        TicketWindows station = new TicketWindows(num);
        List<Integer> list = new Vector<>();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Thread thread = new Thread(() -> {

                //读写操作
                //
                int x = station.sell(getRandom());
                // 临界区，对共享操作有读写操作
                list.add(x);
                try {
                    Thread.sleep(getRandom());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            // 在主线程使用，没有线程共享
            threads.add(thread);
            thread.start();
        }
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        //主线程，得等到所有线程结束


        // 统计卖出的票数和剩余票数

        System.out.println(list.stream().mapToInt(i -> i).sum());

        // 剩余的票数
        System.out.println(station.getNum());
        /*
        1002
        0
         */
//        System.out.println(station.getNum() + list.stream().mapToInt(i->i).sum());
    }

    static Random random = new Random();

    public static int getRandom() {
        return random.nextInt(5) + 1;
    }
}

class TicketWindows {
    private int num;

    public TicketWindows(int x) {
        this.num = x;
    }

    public int sell(int x) {
        synchronized (this) {
            if (num - x >= 0) {
                num -= x;
                System.out.println("sell " + x + " 张票");
                return x;
            } else {
                System.out.println("没有票了");
                return 0;
            }
        }
    }

    //    public int getNum() {
//        synchronized (this) {
//            return num;
//        }
//    }
    public synchronized int getNum() {
        return num;
    }
}
