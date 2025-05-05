package com.chen.pool;

public interface RejectHandler {

    public void reject(Runnable command, SThreadPool sThreadPool);
}

class DiscardRejectHandler implements RejectHandler{
    @Override
    public void reject(Runnable command, SThreadPool sThreadPool) {

    }
}