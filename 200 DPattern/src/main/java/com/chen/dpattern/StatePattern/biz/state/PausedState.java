package com.chen.dpattern.StatePattern.biz.state;

import com.chen.dpattern.StatePattern.infra.entity.WtWorkTicketOperation;
import com.chen.dpattern.StatePattern.infra.enums.ProductionStatus;

/**
 * 已暂停状态 - 具体状态实现
 * 允许：继续、结束；禁止：开始、暂停、完成
 */
public class PausedState implements WorkOrderState {
    @Override
    public void handleStart(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态为已暂停，可直接继续生产，无需重新开始");
    }

    @Override
    public void handlePause(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态已为暂停，无需重复暂停");
    }

    @Override
    public void handleResume(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        // 已暂停→继续→生产中
        currentOp.setPreStatus(ProductionStatus.PAUSED.getCode());
        currentOp.setPostStatus(ProductionStatus.PRODUCING.getCode());
    }

    @Override
    public void handleComplete(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        throw new RuntimeException("当前状态为已暂停，需先继续生产，再执行完成操作");
    }

    @Override
    public void handleEnd(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp) {
        // 已暂停→结束→已结束
        currentOp.setPreStatus(ProductionStatus.PAUSED.getCode());
        currentOp.setPostStatus(ProductionStatus.END.getCode());
    }

    @Override
    public ProductionStatus getStatus() {
        return ProductionStatus.PAUSED;
    }
}