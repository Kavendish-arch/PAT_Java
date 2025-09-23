package com.chen.pool;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义阻塞队列
 * 消息队列
 *
 * @param <T>
 */
public class BlockingQueueImy <T>{

    // 1. 任务队列
    private Deque<T> queue = new ArrayDeque<>();
    // 2. 锁
    private ReentrantLock lock = new ReentrantLock();
    // 3. 生产者条件变量
    private Condition fullWaitSet = lock.newCondition();
    // 4. 消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();
    // 5. 容量
    private int capcity;
    public BlockingQueueImy(int capcity) {
        this.capcity = capcity;
    }

    /**
     * 在指定的超时时间内获取并移除队列中的头部元素
     * 如果队列为空，则会等待指定的超时时间，直到队列中有元素可用或超时时间结束
     *
     * @param timeout 超时时间
     * @param unit    超时时间的时间单位
     * @return 队列中的头部元素，如果超时未获取到则返回null
     * @throws RuntimeException 如果线程被中断
     */
    public T poll(long timeout, TimeUnit unit){
        // 时间转变
        lock.lock();
        try {
            // 将超时时间转换成纳秒
            long nanos = unit.toNanos(timeout);
            // 循环等待
            while (queue.isEmpty()){
                try {
                    // 超时后返回null
                    if(nanos <= 0){
                        return null;
                    }
                    // 超时时间
                    nanos = emptyWaitSet.awaitNanos(nanos);

                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

    /**
     * 从队列中移除并返回头部的元素
     * 如果队列为空，当前线程会等待直到队列中有元素可用
     * 此方法适用于多线程环境下，生产者线程向队列中添加元素，消费者线程从队列中移除元素的场景
     *
     * @return 队列头部的元素
     * @throws RuntimeException 如果线程被中断
     */
    public T take(){
        // 加锁，确保线程安全
        lock.lock();
        try {
            // 如果队列为空，当前线程在此等待，直到其他线程向队列中添加了元素
            while (queue.isEmpty()){
                try {
                    emptyWaitSet.await();
                }catch (InterruptedException e){
                    // 如果线程等待过程中被中断，抛出运行时异常
                    throw new RuntimeException(e);
                }
            }
            // 从队列中移除并返回头部的元素
            T t = queue.removeFirst();
            // 通知可能正在等待队列变为非满的线程
            fullWaitSet.signal();
            return t;
        }finally {
            // 释放锁，确保其他线程可以进入临界区
            lock.unlock();
        }
    }

    /**
     * 将元素添加到队列中
     * 如果队列已满（大小达到100），则等待直到队列不满
     *
     * @param t 要添加到队列中的元素
     * @throws RuntimeException 如果在等待过程中线程被中断
     */
    public void put(T t){
        // 加锁以确保线程安全
        lock.lock();
        try {
            // 当队列大小达到100时，表示队列已满，等待直到队列不满
            while (queue.size() >= 100){
                try {
                    // 等待条件变量fullWaitSet，直到队列不满
                    fullWaitSet.await();
                }catch (InterruptedException e){
                    // 如果在等待过程中线程被中断，抛出运行时异常
                    throw new RuntimeException(e);
                }
            }
            // 添加元素到队列的末尾
            queue.addLast(t);
            // 通知可能在等待队列不满的线程
            emptyWaitSet.signal();
        }finally {
            // 无论如何都要释放锁
            lock.unlock();
        }
    }

    /**
     * 在指定的时间内将元素插入队列
     * 如果队列已满，线程会等待直到队列有空余空间或者等待时间结束
     *
     * @param t 要插入队列的元素
     * @param timeout 等待队列有空余空间的时间长度
     * @param unit 时间单位
     * @return 如果成功插入队列，则返回true；如果等待时间结束后未能插入，则返回false
     * @throws RuntimeException 如果线程被中断
     */
    public boolean offer(T t, long timeout, TimeUnit unit){
        // 加锁以确保线程安全
        lock.lock();
        try {
            // 将等待时间转换为纳秒
            long nanos = unit.toNanos(timeout);
            // 当队列已满时，线程等待
            while (queue.size() >= capcity){
                try {
                    // 如果剩余等待时间小于等于0，则返回false
                    if(nanos <= 0){
                        return false;
                    }
                    // 线程等待，同时减少剩余等待时间
                    nanos = fullWaitSet.awaitNanos(nanos);
                }catch (InterruptedException e){
                    // 如果线程被中断，抛出运行时异常
                    throw new RuntimeException(e);
                }
            }
            // 插入元素到队列末尾
            queue.addLast(t);
            // 通知可能在等待队列变为空的线程
            emptyWaitSet.signal();
            return true;
        } finally {
            // 释放锁
            lock.unlock();
        }
    }
    /**
     * 获取队列的当前大小
     * 此方法用于返回队列中当前元素的数量
     * 它在内部使用锁来防止多个线程同时修改队列，确保数据一致性
     *
     * @return 队列的大小
     */
    public int size(){
        // 加锁以确保线程安全
        lock.lock();
        try {
            // 返回队列的当前大小
            return queue.size();

        } finally {
            // 无论try块中发生什么，最终都要解锁，以保证其他线程可以进入
            lock.unlock();
        }
    }
}
