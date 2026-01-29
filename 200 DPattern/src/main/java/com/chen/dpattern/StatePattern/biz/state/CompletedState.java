package com.chen.dpattern.StatePattern.biz.state;

import com.chen.dpattern.StatePattern.infra.entity.WtWorkTicketOperation;
import com.chen.dpattern.StatePattern.infra.enums.ProductionStatus;

/**
 * 已完成状态 - 具体状态实现（新增）
 * 允许：重新开始、结束；禁止：暂停、继续、重复完成
 */
public class CompletedState implements WorkOrderState {
    @Override
    public void handleStart(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        // 已完成→重新开始→生产中
        currentOp.setPreStatus(ProductionStatus.COMPLETED.getCode());
        currentOp.setPostStatus(ProductionStatus.PRODUCING.getCode());
    }

    @Override
    public void handlePause(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态为已完成，无生产行为，不允许暂停");
    }

    @Override
    public void handleResume(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态为已完成，非暂停状态，无法继续生产");
    }

    @Override
    public void handleComplete(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态已完成，无需重复执行完成操作");
    }

    @Override
    public void handleEnd(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        // 已完成→结束→已结束（强制归档）
        currentOp.setPreStatus(ProductionStatus.COMPLETED.getCode());
        currentOp.setPostStatus(ProductionStatus.END.getCode());
    }

    @Override
    public ProductionStatus getStatus() {
        return ProductionStatus.COMPLETED;
    }
}