package com.chen.pool;


public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueueImy<Integer> queue = new BlockingQueueImy<>(3);

        Thread producer1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                queue.put(i);
                System.out.println("Producer1 put: " + i);
            }
        });

        Thread producer2 = new Thread(() -> {
            for (int i = 5; i < 10; i++) {
                queue.put(i);
                System.out.println("Producer2 put: " + i);
            }
        });

        Thread consumer1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Integer value = queue.take();
                System.out.println("Consumer1 took: " + value);
            }
        });

        Thread consumer2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Integer value = queue.take();
                System.out.println("Consumer2 took: " + value);
            }
        });

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        producer1.join();
        producer2.join();
        consumer1.join();
        consumer2.join();
    }
}
