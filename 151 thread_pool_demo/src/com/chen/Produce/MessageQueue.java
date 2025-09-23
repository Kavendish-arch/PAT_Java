package com.chen.Produce;

/**
 *
 */

import java.util.LinkedList;

/**
 * The Message class represents a message object, which has a unique identifier and message content
 */
class Message {
    // Identifier for the message
    private int id;
    // The content of the message
    private String message;

    /**
     * Constructs a Message object with the specified identifier and message content
     *
     * @param id      The unique identifier for the message
     * @param message The content of the message
     */
    public Message(int id, String message) {
        this.id = id;
        this.message = message;
    }

    /**
     * Sets the content of the message
     *
     * @param message The new content of the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the content of the message
     *
     * @return The content of the message
     */
    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


public class MessageQueue<T> {
    private final LinkedList<T> queue;
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<T>();
    }

    /**
     * 从队列中移除并返回第一个元素
     * 如果队列为空，线程会被阻塞，直到其他线程向队列中添加了元素
     * 此方法使用同步块来确保线程安全，并使用wait/notifyAll机制来处理空队列的情况
     *
     * @return T 返回队列中的第一个元素
     * @throws RuntimeException 如果线程被中断，抛出运行时异常
     */
    public T take() {
        synchronized (queue) {
            // 队列为空，需要阻塞
            while (queue.isEmpty()) {
                try {
                    System.out.println("队列为空，当前线程被阻塞");
                    // 阻塞当前线程，直到被唤醒
                    queue.wait();
                } catch (InterruptedException e) {
                    // 如果线程被中断，抛出运行时异常
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            // 队列非空，需要唤醒
            T t = queue.removeFirst();
            // 唤醒所有等待的线程
            queue.notifyAll();
            return t;
        }
    }


    /**
     * 向队列中添加一个元素
     * 如果队列已满，则当前线程会被阻塞，直到队列中有空余位置
     *
     * @param t 要添加到队列中的元素
     * @throws RuntimeException 如果线程被中断，则抛出运行时异常
     */
    public void put(T t) {
        synchronized (queue) {
            // 当队列已满时，当前线程进入等待状态，释放锁
            while (queue.size() >= capacity) {
                try {
                    System.out.println("队列已满，当前线程被阻塞");
                    queue.wait();
                } catch (InterruptedException e) {
                    // 如果线程被中断，恢复中断状态，并抛出异常
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }

            // 队列未满，添加元素
            queue.addLast(t);
            // 添加元素后，通知所有等待的线程，队列状态已改变
            queue.notifyAll();
        }
    }

    public static void main(String[] args) {


        MessageQueue<Message> queue = new MessageQueue<>(3);
        //
        for (int i = 0; i < 10; i++) {
            int id = i;
            new Thread(() -> {
                System.out.println("下载任务进行中");
                System.out.println("送入队列");
                Message message = new Message(id, "下载任务");
                queue.put(message);
            }, "Thread-" + i).start();
        }


        new Thread(() -> {
            while (true) {
                System.out.println("从队列中取出");
                Message message = queue.take();
                System.out.println(message.getId() + ": " + message.getMessage());
            }
        }, "Thread-消费者").start();
    }
}
