package com.chen.dpattern.StatePattern.biz.state;

import com.chen.dpattern.StatePattern.infra.entity.WtWorkTicketOperation;
import com.chen.dpattern.StatePattern.infra.enums.ProductionStatus;
import com.chen.dpattern.StatePattern.infra.enums.WorkOrderProductionAct;

/**
 * 任务单状态上下文
 * 核心职责：初始化当前状态、分发操作到具体状态、操作成功后切换状态
 */
public class WorkOrderStateContext {
    // 持有当前状态对象（状态模式核心）
    private WorkOrderState currentState;

    /**
     * 构造方法：根据最后一条操作记录初始化当前状态
     * @param lastOp 最后一条操作记录（null表示无操作记录）
     */
    public WorkOrderStateContext(WtWorkTicketOperation lastOp) {
        this.currentState = initCurrentState(lastOp);
    }

    /**
     * 初始化当前状态
     * 无记录→待处理；有记录→取最后操作的后置状态
     */
    private WorkOrderState initCurrentState(WtWorkTicketOperation lastOp) {
        if (lastOp == null) {
            return new PendingState();
        }
        // 根据最后操作的后置状态获取对应状态对象
        ProductionStatus lastStatus = ProductionStatus.getByCode(lastOp.getPostStatus());
        return switch (lastStatus) {
            case PENDING -> new PendingState();
            case PRODUCING -> new ProducingState();
            case PAUSED -> new PausedState();
            case COMPLETED -> new CompletedState();
            case END -> new EndState();
        };
    }

    /**
     * 执行操作：将操作分发到当前状态对象处理，并切换状态
     * @param act 当前操作动作
     * @param currentOp 当前操作记录（用于设置前置/后置状态）
     * @param lastOp 最后一条操作记录
     */
    public void executeOperation(WorkOrderProductionAct act,
                                 WtWorkTicketOperation currentOp,
                                 WtWorkTicketOperation lastOp) {
        // 分发操作到具体状态
        switch (act) {
            case START_PRODUCTION -> currentState.handleStart(currentOp, lastOp);
            case PAUSE_PRODUCTION -> currentState.handlePause(currentOp, lastOp);
            case RESUME_PRODUCTION -> currentState.handleResume(currentOp, lastOp);
            case COMPLETE_PRODUCTION -> currentState.handleComplete(currentOp, lastOp);
            case END_PRODUCTION -> currentState.handleEnd(currentOp, lastOp);
        }
        // 操作成功后，切换上下文的当前状态为本次操作的后置状态
        this.currentState = switchState(currentOp.getPostStatus());
    }

    /**
     * 根据状态编码切换为新的状态对象
     */
    private WorkOrderState switchState(String statusCode) {
        ProductionStatus status = ProductionStatus.getByCode(statusCode);
        return switch (status) {
            case PENDING -> new PendingState();
            case PRODUCING -> new ProducingState();
            case PAUSED -> new PausedState();
            case COMPLETED -> new CompletedState();
            case END -> new EndState();
        };
    }

    // 获取当前状态对象
    public WorkOrderState getCurrentState() {
        return currentState;
    }
}