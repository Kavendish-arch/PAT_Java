package com.chen.pool.impl;

import com.chen.pool.RejectHandler;
import com.chen.pool.SThreadPool;
/**
 * 实现RejectHandler接口的丢弃最老任务策略类
 * 当线程池的任务队列已满且线程数达到最大时，新提交的任务将根据此策略处理
 * 本策略选择丢弃当前队列中最老的任务，以腾出空间给新任务
 */
public class DiscardOldestPolicyRejectHandle implements RejectHandler {
    /**
     * 处理任务拒绝的方法
     * 当任务无法被线程池执行时调用，本实现选择丢弃最老的任务并尝试执行新任务
     *
     * @param command 被拒绝执行的任务
     * @param sThreadPool 线程池对象，提供了对线程池操作的方法
     */
    @Override
    public void reject(Runnable command, SThreadPool sThreadPool) {
        try {
            // 通知用户队列已满，准备丢弃最老任务
            System.out.println("队列已满，丢弃最老的请求");
            // 从队列中移除最老的任务
            Runnable runnable = sThreadPool.coreQueue.take();
            // 输出被丢弃任务的信息
            System.out.println("丢弃的请求为：" + runnable.toString());
        } catch (InterruptedException e) {
            // 如果线程被中断，则抛出运行时异常
            throw new RuntimeException(e);
        }
        // 尝试执行新任务
        sThreadPool.execute(command);
    }
}

