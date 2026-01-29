package com.chen.dpattern.StatePattern.biz.state;

import com.chen.dpattern.StatePattern.infra.entity.WtWorkTicketOperation;
import com.chen.dpattern.StatePattern.infra.enums.ProductionStatus;
import com.chen.dpattern.StatePattern.infra.enums.WorkOrderProductionAct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 状态模式核心测试用例
 * 测试状态初始化、操作执行、状态切换和异常处理
 */
class WorkOrderStateContextTest {

    private WtWorkTicketOperation currentOp;
    private WtWorkTicketOperation lastOp;

    @BeforeEach
    void setUp() {
        // 初始化当前操作记录
        currentOp = new WtWorkTicketOperation();
        currentOp.setEoId("TEST-E001");
        currentOp.setOperatorId(1L);
        currentOp.setOperationTime(new Date());
        currentOp.setEquipmentId(100L);
        currentOp.setRemark("测试操作");

        // 初始化最后操作记录（用于测试状态初始化）
        lastOp = new WtWorkTicketOperation();
        lastOp.setEoId("TEST-E001");
        lastOp.setPostStatus(ProductionStatus.PRODUCING.getCode());
    }

    @Test
    @DisplayName("测试无操作记录时的状态初始化")
    void testInitStateWithNullLastOp() {
        // 无操作记录时，应初始化为待处理状态
        WorkOrderStateContext context = new WorkOrderStateContext(null);
        assertEquals(ProductionStatus.PENDING, context.getCurrentState().getStatus(), "无操作记录时应初始化为待处理状态");
    }

    @Test
    @DisplayName("测试有操作记录时的状态初始化")
    void testInitStateWithLastOp() {
        // 有操作记录时，应根据最后操作的后置状态初始化
        lastOp.setPostStatus(ProductionStatus.PRODUCING.getCode());
        WorkOrderStateContext context = new WorkOrderStateContext(lastOp);
        assertEquals(ProductionStatus.PRODUCING, context.getCurrentState().getStatus(), "有操作记录时应根据后置状态初始化");

        // 测试其他状态的初始化
        lastOp.setPostStatus(ProductionStatus.PAUSED.getCode());
        context = new WorkOrderStateContext(lastOp);
        assertEquals(ProductionStatus.PAUSED, context.getCurrentState().getStatus());

        lastOp.setPostStatus(ProductionStatus.COMPLETED.getCode());
        context = new WorkOrderStateContext(lastOp);
        assertEquals(ProductionStatus.COMPLETED, context.getCurrentState().getStatus());

        lastOp.setPostStatus(ProductionStatus.END.getCode());
        context = new WorkOrderStateContext(lastOp);
        assertEquals(ProductionStatus.END, context.getCurrentState().getStatus());
    }

    @Test
    @DisplayName("测试待处理状态的合法操作")
    void testPendingStateLegalOperation() {
        // 初始化待处理状态
        WorkOrderStateContext context = new WorkOrderStateContext(null);
        assertEquals(ProductionStatus.PENDING, context.getCurrentState().getStatus());

        // 测试开始生产操作（合法）
        currentOp.setOperationAct(WorkOrderProductionAct.START_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.START_PRODUCTION, currentOp, null);
        assertEquals(ProductionStatus.PENDING.getCode(), currentOp.getPreStatus());
        assertEquals(ProductionStatus.PRODUCING.getCode(), currentOp.getPostStatus());
        assertEquals(ProductionStatus.PRODUCING, context.getCurrentState().getStatus());
    }

    @Test
    @DisplayName("测试待处理状态的非法操作")
    void testPendingStateIllegalOperations() {
        WorkOrderStateContext context = new WorkOrderStateContext(null);

        // 测试暂停操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.PAUSE_PRODUCTION.getValue());
        RuntimeException pauseException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.PAUSE_PRODUCTION, currentOp, null);
        });
        assertEquals("当前状态为待处理，未开始生产，不允许暂停", pauseException.getMessage());

        // 测试继续操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.RESUME_PRODUCTION.getValue());
        RuntimeException resumeException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.RESUME_PRODUCTION, currentOp, null);
        });
        assertEquals("当前状态为待处理，非暂停状态，无法继续生产", resumeException.getMessage());

        // 测试完成操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.COMPLETE_PRODUCTION.getValue());
        RuntimeException completeException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.COMPLETE_PRODUCTION, currentOp, null);
        });
        assertEquals("当前状态为待处理，未开始生产，无法执行完成操作", completeException.getMessage());

        // 测试结束操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.END_PRODUCTION.getValue());
        RuntimeException endException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.END_PRODUCTION, currentOp, null);
        });
        assertEquals("当前状态为待处理，未开始生产，不允许结束", endException.getMessage());
    }

    @Test
    @DisplayName("测试生产中状态的合法操作")
    void testProducingStateLegalOperations() {
        // 初始化生产中状态
        lastOp.setPostStatus(ProductionStatus.PRODUCING.getCode());
        WorkOrderStateContext context = new WorkOrderStateContext(lastOp);
        assertEquals(ProductionStatus.PRODUCING, context.getCurrentState().getStatus());

        // 测试暂停操作（合法）
        currentOp.setOperationAct(WorkOrderProductionAct.PAUSE_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.PAUSE_PRODUCTION, currentOp, lastOp);
        assertEquals(ProductionStatus.PRODUCING.getCode(), currentOp.getPreStatus());
        assertEquals(ProductionStatus.PAUSED.getCode(), currentOp.getPostStatus());
        assertEquals(ProductionStatus.PAUSED, context.getCurrentState().getStatus());

        // 重新初始化生产中状态
        context = new WorkOrderStateContext(lastOp);

        // 测试完成操作（合法）
        currentOp.setOperationAct(WorkOrderProductionAct.COMPLETE_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.COMPLETE_PRODUCTION, currentOp, lastOp);
        assertEquals(ProductionStatus.PRODUCING.getCode(), currentOp.getPreStatus());
        assertEquals(ProductionStatus.COMPLETED.getCode(), currentOp.getPostStatus());
        assertEquals(ProductionStatus.COMPLETED, context.getCurrentState().getStatus());

        // 重新初始化生产中状态
        context = new WorkOrderStateContext(lastOp);

        // 测试结束操作（合法）
        currentOp.setOperationAct(WorkOrderProductionAct.END_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.END_PRODUCTION, currentOp, lastOp);
        assertEquals(ProductionStatus.PRODUCING.getCode(), currentOp.getPreStatus());
        assertEquals(ProductionStatus.END.getCode(), currentOp.getPostStatus());
        assertEquals(ProductionStatus.END, context.getCurrentState().getStatus());
    }

    @Test
    @DisplayName("测试生产中状态的非法操作")
    void testProducingStateIllegalOperations() {
        lastOp.setPostStatus(ProductionStatus.PRODUCING.getCode());
        WorkOrderStateContext context = new WorkOrderStateContext(lastOp);

        // 测试开始操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.START_PRODUCTION.getValue());
        RuntimeException startException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.START_PRODUCTION, currentOp, lastOp);
        });
        assertEquals("生产已经在进行中，无需再次开始", startException.getMessage());

        // 测试继续操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.RESUME_PRODUCTION.getValue());
        RuntimeException resumeException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.RESUME_PRODUCTION, currentOp, lastOp);
        });
        assertEquals("当前状态为生产中，非暂停状态，无法继续生产", resumeException.getMessage());
    }

    @Test
    @DisplayName("测试已暂停状态的合法操作")
    void testPausedStateLegalOperations() {
        // 初始化已暂停状态
        lastOp.setPostStatus(ProductionStatus.PAUSED.getCode());
        WorkOrderStateContext context = new WorkOrderStateContext(lastOp);
        assertEquals(ProductionStatus.PAUSED, context.getCurrentState().getStatus());

        // 测试继续操作（合法）
        currentOp.setOperationAct(WorkOrderProductionAct.RESUME_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.RESUME_PRODUCTION, currentOp, lastOp);
        assertEquals(ProductionStatus.PAUSED.getCode(), currentOp.getPreStatus());
        assertEquals(ProductionStatus.PRODUCING.getCode(), currentOp.getPostStatus());
        assertEquals(ProductionStatus.PRODUCING, context.getCurrentState().getStatus());

        // 重新初始化已暂停状态
        context = new WorkOrderStateContext(lastOp);

        // 测试结束操作（合法）
        currentOp.setOperationAct(WorkOrderProductionAct.END_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.END_PRODUCTION, currentOp, lastOp);
        assertEquals(ProductionStatus.PAUSED.getCode(), currentOp.getPreStatus());
        assertEquals(ProductionStatus.END.getCode(), currentOp.getPostStatus());
        assertEquals(ProductionStatus.END, context.getCurrentState().getStatus());
    }

    @Test
    @DisplayName("测试已暂停状态的非法操作")
    void testPausedStateIllegalOperations() {
        lastOp.setPostStatus(ProductionStatus.PAUSED.getCode());
        WorkOrderStateContext context = new WorkOrderStateContext(lastOp);

        // 测试开始操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.START_PRODUCTION.getValue());
        RuntimeException startException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.START_PRODUCTION, currentOp, lastOp);
        });
        assertEquals("当前状态为已暂停，可直接继续生产，无需重新开始", startException.getMessage());

        // 测试暂停操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.PAUSE_PRODUCTION.getValue());
        RuntimeException pauseException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.PAUSE_PRODUCTION, currentOp, lastOp);
        });
        assertEquals("当前状态已为暂停，无需重复暂停", pauseException.getMessage());

        // 测试完成操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.COMPLETE_PRODUCTION.getValue());
        RuntimeException completeException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.COMPLETE_PRODUCTION, currentOp, lastOp);
        });
        assertEquals("当前状态为已暂停，需先继续生产，再执行完成操作", completeException.getMessage());
    }

    @Test
    @DisplayName("测试已完成状态的合法操作")
    void testCompletedStateLegalOperations() {
        // 初始化已完成状态
        lastOp.setPostStatus(ProductionStatus.COMPLETED.getCode());
        WorkOrderStateContext context = new WorkOrderStateContext(lastOp);
        assertEquals(ProductionStatus.COMPLETED, context.getCurrentState().getStatus());

        // 测试重新开始操作（合法）
        currentOp.setOperationAct(WorkOrderProductionAct.START_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.START_PRODUCTION, currentOp, lastOp);
        assertEquals(ProductionStatus.COMPLETED.getCode(), currentOp.getPreStatus());
        assertEquals(ProductionStatus.PRODUCING.getCode(), currentOp.getPostStatus());
        assertEquals(ProductionStatus.PRODUCING, context.getCurrentState().getStatus());

        // 重新初始化已完成状态
        context = new WorkOrderStateContext(lastOp);

        // 测试结束操作（合法）
        currentOp.setOperationAct(WorkOrderProductionAct.END_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.END_PRODUCTION, currentOp, lastOp);
        assertEquals(ProductionStatus.COMPLETED.getCode(), currentOp.getPreStatus());
        assertEquals(ProductionStatus.END.getCode(), currentOp.getPostStatus());
        assertEquals(ProductionStatus.END, context.getCurrentState().getStatus());
    }

    @Test
    @DisplayName("测试已完成状态的非法操作")
    void testCompletedStateIllegalOperations() {
        lastOp.setPostStatus(ProductionStatus.COMPLETED.getCode());
        WorkOrderStateContext context = new WorkOrderStateContext(lastOp);

        // 测试暂停操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.PAUSE_PRODUCTION.getValue());
        RuntimeException pauseException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.PAUSE_PRODUCTION, currentOp, lastOp);
        });
        assertEquals("当前状态为已完成，无生产行为，不允许暂停", pauseException.getMessage());

        // 测试继续操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.RESUME_PRODUCTION.getValue());
        RuntimeException resumeException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.RESUME_PRODUCTION, currentOp, lastOp);
        });
        assertEquals("当前状态为已完成，非暂停状态，无法继续生产", resumeException.getMessage());

        // 测试完成操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.COMPLETE_PRODUCTION.getValue());
        RuntimeException completeException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.COMPLETE_PRODUCTION, currentOp, lastOp);
        });
        assertEquals("当前状态已完成，无需重复执行完成操作", completeException.getMessage());
    }

    @Test
    @DisplayName("测试已结束状态的合法操作")
    void testEndStateLegalOperations() {
        // 初始化已结束状态
        lastOp.setPostStatus(ProductionStatus.END.getCode());
        WorkOrderStateContext context = new WorkOrderStateContext(lastOp);
        assertEquals(ProductionStatus.END, context.getCurrentState().getStatus());

        // 测试重新开始操作（合法）
        currentOp.setOperationAct(WorkOrderProductionAct.START_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.START_PRODUCTION, currentOp, lastOp);
        assertEquals(ProductionStatus.END.getCode(), currentOp.getPreStatus());
        assertEquals(ProductionStatus.PRODUCING.getCode(), currentOp.getPostStatus());
        assertEquals(ProductionStatus.PRODUCING, context.getCurrentState().getStatus());
    }

    @Test
    @DisplayName("测试已结束状态的非法操作")
    void testEndStateIllegalOperations() {
        lastOp.setPostStatus(ProductionStatus.END.getCode());
        WorkOrderStateContext context = new WorkOrderStateContext(lastOp);

        // 测试暂停操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.PAUSE_PRODUCTION.getValue());
        RuntimeException pauseException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.PAUSE_PRODUCTION, currentOp, lastOp);
        });
        assertEquals("当前状态为已结束，无生产行为，不允许暂停", pauseException.getMessage());

        // 测试继续操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.RESUME_PRODUCTION.getValue());
        RuntimeException resumeException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.RESUME_PRODUCTION, currentOp, lastOp);
        });
        assertEquals("当前状态为已结束，非暂停状态，无法继续生产", resumeException.getMessage());

        // 测试完成操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.COMPLETE_PRODUCTION.getValue());
        RuntimeException completeException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.COMPLETE_PRODUCTION, currentOp, lastOp);
        });
        assertEquals("当前状态为已结束，无需执行完成操作", completeException.getMessage());

        // 测试结束操作（非法）
        currentOp.setOperationAct(WorkOrderProductionAct.END_PRODUCTION.getValue());
        RuntimeException endException = assertThrows(RuntimeException.class, () -> {
            context.executeOperation(WorkOrderProductionAct.END_PRODUCTION, currentOp, lastOp);
        });
        assertEquals("当前状态已结束，不允许重复结束操作", endException.getMessage());
    }

    @Test
    @DisplayName("测试完整的状态转换流程")
    void testCompleteStateTransitionFlow() {
        // 初始化待处理状态
        WorkOrderStateContext context = new WorkOrderStateContext(null);
        assertEquals(ProductionStatus.PENDING, context.getCurrentState().getStatus());

        // 流程：待处理 → 生产中
        currentOp.setOperationAct(WorkOrderProductionAct.START_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.START_PRODUCTION, currentOp, null);
        assertEquals(ProductionStatus.PRODUCING, context.getCurrentState().getStatus());

        // 流程：生产中 → 已暂停
        currentOp.setOperationAct(WorkOrderProductionAct.PAUSE_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.PAUSE_PRODUCTION, currentOp, lastOp);
        assertEquals(ProductionStatus.PAUSED, context.getCurrentState().getStatus());

        // 流程：已暂停 → 生产中
        currentOp.setOperationAct(WorkOrderProductionAct.RESUME_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.RESUME_PRODUCTION, currentOp, lastOp);
        assertEquals(ProductionStatus.PRODUCING, context.getCurrentState().getStatus());

        // 流程：生产中 → 已完成
        currentOp.setOperationAct(WorkOrderProductionAct.COMPLETE_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.COMPLETE_PRODUCTION, currentOp, lastOp);
        assertEquals(ProductionStatus.COMPLETED, context.getCurrentState().getStatus());

        // 流程：已完成 → 已结束
        currentOp.setOperationAct(WorkOrderProductionAct.END_PRODUCTION.getValue());
        context.executeOperation(WorkOrderProductionAct.END_PRODUCTION, currentOp, lastOp);
        assertEquals(ProductionStatus.END, context.getCurrentState().getStatus());
    }
}
