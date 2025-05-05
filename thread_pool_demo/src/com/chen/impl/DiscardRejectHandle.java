package com.chen.impl;


import com.chen.pool.RejectHandler;
import com.chen.pool.SThreadPool;

public class DiscardRejectHandle implements RejectHandler {
    @Override
    public void reject(Runnable command, SThreadPool sThreadPool) {

    }
}
