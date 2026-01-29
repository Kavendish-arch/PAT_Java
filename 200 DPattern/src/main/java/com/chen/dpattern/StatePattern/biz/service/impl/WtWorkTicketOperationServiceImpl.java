package com.chen.dpattern.StatePattern.biz.service.impl;

import com.chen.dpattern.StatePattern.biz.state.WorkOrderStateContext;
import com.chen.dpattern.StatePattern.infra.entity.WtWorkTicketOperation;
import com.chen.dpattern.StatePattern.infra.enums.WorkOrderProductionAct;
import com.chen.dpattern.StatePattern.infra.mapper.WtWorkTicketOperationRepository;

import java.util.List;

/**
 * 任务单操作状态更新服务 整合状态模式，实现无分支、高拓展的状态变换逻辑
 */
public class WtWorkTicketOperationServiceImpl {

    private WtWorkTicketOperationRepository wtWorkTicketOperationRepository;

    // 构造方法注入依赖
    public WtWorkTicketOperationServiceImpl(WtWorkTicketOperationRepository wtWorkTicketOperationRepository) {
        this.wtWorkTicketOperationRepository = wtWorkTicketOperationRepository;
    }

    // 默认构造方法
    public WtWorkTicketOperationServiceImpl() {
    }

    // setter方法注入依赖
    public void setWtWorkTicketOperationRepository(WtWorkTicketOperationRepository wtWorkTicketOperationRepository) {
        this.wtWorkTicketOperationRepository = wtWorkTicketOperationRepository;
    }

    /**
     * 更新任务单状态（核心方法）
     *
     * @param wtWorkTicketOperation 当前操作记录
     * @return 插入结果（数据库影响行数）
     */
    public int updateStatus(WtWorkTicketOperation wtWorkTicketOperation) {
        // 1. 前置参数非空校验（基础校验，避免空指针）
        validateParam(wtWorkTicketOperation);

        // 2. 获取该任务单的最后一条操作记录（用于初始化状态）
        WtWorkTicketOperation lastOperation = getLastOperation(wtWorkTicketOperation);

        // 3. 状态模式核心执行：初始化上下文→转换操作枚举→执行操作
        WorkOrderStateContext context = new WorkOrderStateContext(lastOperation);
        WorkOrderProductionAct currentAct = WorkOrderProductionAct.getByValue(wtWorkTicketOperation.getOperationAct());
        context.executeOperation(currentAct, wtWorkTicketOperation, lastOperation);

        // 4. 插入新的操作记录到数据库
        return wtWorkTicketOperationRepository.insert(wtWorkTicketOperation);
    }

    /**
     * 参数非空校验
     */
    private void validateParam(WtWorkTicketOperation wtWorkTicketOperation) {
        if (wtWorkTicketOperation.getEoId() == null) {
            throw new RuntimeException("请选择工单");
        }
        if (wtWorkTicketOperation.getOperatorId() == null) {
            throw new RuntimeException("请选择操作人");
        }
        if (wtWorkTicketOperation.getOperationTime() == null) {
            throw new RuntimeException("请选择操作时间");
        }
        if (wtWorkTicketOperation.getOperationAct() == null) {
            throw new RuntimeException("请选择操作动作");
        }
        if (wtWorkTicketOperation.getEquipmentId() == null) {
            throw new RuntimeException("请选择设备");
        }
    }

    /**
     * 获取任务单的最后一条操作记录
     */
    private WtWorkTicketOperation getLastOperation(WtWorkTicketOperation wtWorkTicketOperation) {
        List<WtWorkTicketOperation> opList = wtWorkTicketOperationRepository.selectList(wtWorkTicketOperation);
        if (opList == null || opList.isEmpty()) {
            return null;
        }
        // 返回最后一条记录（按操作时间/主键排序后）
        return opList.get(opList.size() - 1);
    }
}
