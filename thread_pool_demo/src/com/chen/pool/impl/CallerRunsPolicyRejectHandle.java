package com.chen.pool.impl;

import com.chen.pool.RejectHandler;
import com.chen.pool.SThreadPool;

public class CallerRunsPolicyRejectHandle implements RejectHandler {

    @Override
    public void reject(Runnable command, SThreadPool sThreadPool) {
        if (sThreadPool.isShutdown()) {
            // 如果线程池被关闭，则抛出运行时异常
            throw new RuntimeException("线程池被关闭");
        } else {
            // 如果线程池没有被关闭，则直接执行被拒绝的任务
            command.run();
        }
    }
}
