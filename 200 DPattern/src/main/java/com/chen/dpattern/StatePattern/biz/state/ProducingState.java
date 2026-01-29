package com.chen.dpattern.StatePattern.biz.state;

import com.chen.dpattern.StatePattern.infra.entity.WtWorkTicketOperation;
import com.chen.dpattern.StatePattern.infra.enums.ProductionStatus;

/**
 * 生产中状态 - 具体状态实现
 * 允许：暂停、完成、结束；禁止：重复开始、继续
 */
public class ProducingState implements WorkOrderState {
    @Override
    public void handleStart(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("生产已经在进行中，无需再次开始");
    }

    @Override
    public void handlePause(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        // 生产中→暂停→已暂停
        currentOp.setPreStatus(ProductionStatus.PRODUCING.getCode());
        currentOp.setPostStatus(ProductionStatus.PAUSED.getCode());
    }

    @Override
    public void handleResume(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态为生产中，非暂停状态，无法继续生产");
    }

    @Override
    public void handleComplete(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        // 生产中→完成→已完成（新增核心逻辑）
        currentOp.setPreStatus(ProductionStatus.PRODUCING.getCode());
        currentOp.setPostStatus(ProductionStatus.COMPLETED.getCode());
    }

    @Override
    public void handleEnd(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        // 生产中→结束→已结束
        currentOp.setPreStatus(ProductionStatus.PRODUCING.getCode());
        currentOp.setPostStatus(ProductionStatus.END.getCode());
    }

    @Override
    public ProductionStatus getStatus() {
        return ProductionStatus.PRODUCING;
    }
}