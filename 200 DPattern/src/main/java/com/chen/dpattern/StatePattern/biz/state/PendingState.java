package com.chen.dpattern.StatePattern.biz.state;

import com.chen.dpattern.StatePattern.infra.entity.WtWorkTicketOperation;
import com.chen.dpattern.StatePattern.infra.enums.ProductionStatus;

/**
 * 待处理状态 - 具体状态实现
 * 仅允许：开始生产；其他操作均为非法
 */
public class PendingState implements WorkOrderState {
    @Override
    public void handleStart(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        // 待处理→开始生产→生产中
        currentOp.setPreStatus(ProductionStatus.PENDING.getCode());
        currentOp.setPostStatus(ProductionStatus.PRODUCING.getCode());
    }

    @Override
    public void handlePause(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态为待处理，未开始生产，不允许暂停");
    }

    @Override
    public void handleResume(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态为待处理，非暂停状态，无法继续生产");
    }

    @Override
    public void handleComplete(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态为待处理，未开始生产，无法执行完成操作");
    }

    @Override
    public void handleEnd(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态为待处理，未开始生产，不允许结束");
    }

    @Override
    public ProductionStatus getStatus() {
        return ProductionStatus.PENDING;
    }
}