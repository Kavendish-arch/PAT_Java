package com.chen.dpattern.StatePattern.biz.state;

import com.chen.dpattern.StatePattern.infra.entity.WtWorkTicketOperation;
import com.chen.dpattern.StatePattern.infra.enums.ProductionStatus;

/**
 * 已结束状态 - 具体状态实现
 * 允许：重新开始；其他操作均为非法
 */
public class EndState implements WorkOrderState {
    @Override
    public void handleStart(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        // 已结束→重新开始→生产中
        currentOp.setPreStatus(ProductionStatus.END.getCode());
        currentOp.setPostStatus(ProductionStatus.PRODUCING.getCode());
    }

    @Override
    public void handlePause(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态为已结束，无生产行为，不允许暂停");
    }

    @Override
    public void handleResume(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态为已结束，非暂停状态，无法继续生产");
    }

    @Override
    public void handleComplete(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态为已结束，无需执行完成操作");
    }

    @Override
    public void handleEnd(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态已结束，不允许重复结束操作");
    }

    @Override
    public ProductionStatus getStatus() {
        return ProductionStatus.END;
    }
}