package com.chen.pool;

/**
 * 接口用于处理任务拒绝执行的情况
 * 当线程池无法再接受新任务时，通过实现此接口来定义拒绝任务的处理策略
 */
public interface RejectHandler {

    /**
     * 处理被拒绝的任务
     *
     * @param command 被拒绝执行的任务
     * @param sThreadPool 拒绝执行任务的线程池
     */
    public void reject(Runnable command, SThreadPool sThreadPool);
}
