package com.chen.dpattern.StatePattern.biz.state;

import com.chen.dpattern.StatePattern.infra.entity.WtWorkTicketOperation;
import com.chen.dpattern.StatePattern.infra.enums.ProductionStatus;

/**
 * 任务单状态抽象接口
 * 声明所有操作的处理方法，约束具体状态类的实现
 */
public interface WorkOrderState {
    /**
     * 处理开始生产操作
     */
    void handleStart(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp);

    /**
     * 处理暂停生产操作
     */
    void handlePause(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp);

    /**
     * 处理继续生产操作
     */
    void handleResume(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp);

    /**
     * 处理完成生产操作
     */
    void handleComplete(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp);

    /**
     * 处理结束生产操作
     */
    void handleEnd(WtWorkTicketOperation currentOp, WtWorkTicketOperation lastOp);

    /**
     * 获取当前状态枚举
     */
    ProductionStatus getStatus();
}