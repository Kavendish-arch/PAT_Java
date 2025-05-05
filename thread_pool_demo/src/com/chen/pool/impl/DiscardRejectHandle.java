package com.chen.pool.impl;


import com.chen.pool.RejectHandler;
import com.chen.pool.SThreadPool;

/**
 * DiscardRejectHandle类实现了RejectHandler接口，用于处理任务拒绝执行的情况
 * 它的处理方式是直接丢弃被拒绝的任务，不进行任何处理或记录
 * 这种策略适用于对任务丢失不敏感的场景，确保系统能够继续处理后续任务，避免因为单个任务导致系统停顿
 */
public class DiscardRejectHandle implements RejectHandler {
    /**
     * 当任务无法被执行时，此方法将被调用
     * 它直接丢弃被拒绝的任务，不执行任何操作
     *
     * @param command 被拒绝执行的任务
     * @param sThreadPool 发生任务拒绝的线程池
     */
    @Override
    public void reject(Runnable command, SThreadPool sThreadPool) {
        // 此处不执行任何操作，直接丢弃被拒绝的任务
    }
}

