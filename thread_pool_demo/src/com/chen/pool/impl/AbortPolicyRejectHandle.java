package com.chen.pool.impl;

import com.chen.pool.RejectHandler;
import com.chen.pool.SThreadPool;

public class AbortPolicyRejectHandle implements RejectHandler {
    @Override
    public void reject(Runnable command, SThreadPool sThreadPool) {
        throw new RuntimeException("线程池已满，请稍后重试");
    }
}
