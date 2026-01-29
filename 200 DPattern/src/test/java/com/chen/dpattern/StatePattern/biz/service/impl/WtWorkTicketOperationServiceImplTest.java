package com.chen.dpattern.StatePattern.biz.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.chen.dpattern.StatePattern.infra.entity.WtWorkTicketOperation;
import com.chen.dpattern.StatePattern.infra.enums.ProductionStatus;
import com.chen.dpattern.StatePattern.infra.enums.WorkOrderProductionAct;
import com.chen.dpattern.StatePattern.infra.mapper.WtWorkTicketOperationRepository;

/**
 * 业务服务测试用例 测试参数校验、状态模式集成和异常处理
 */
@ExtendWith(MockitoExtension.class)
class WtWorkTicketOperationServiceImplTest {

    @Mock
    private WtWorkTicketOperationRepository wtWorkTicketOperationRepository;

    @InjectMocks
    private WtWorkTicketOperationServiceImpl service;

    private WtWorkTicketOperation wtWorkTicketOperation;
    private List<WtWorkTicketOperation> operationList;

    @BeforeEach
    void setUp() {
        // 初始化测试数据
        wtWorkTicketOperation = new WtWorkTicketOperation();
        wtWorkTicketOperation.setEoId("TEST-E001");
        wtWorkTicketOperation.setOperatorId(1L);
        wtWorkTicketOperation.setOperationTime(new Date());
        wtWorkTicketOperation.setOperationAct(WorkOrderProductionAct.START_PRODUCTION.getValue());
        wtWorkTicketOperation.setEquipmentId(100L);
        wtWorkTicketOperation.setRemark("测试操作");

        // 初始化操作记录列表
        operationList = new ArrayList<>();
        WtWorkTicketOperation lastOp = new WtWorkTicketOperation();
        lastOp.setEoId("TEST-E001");
        lastOp.setPostStatus(ProductionStatus.PRODUCING.getCode());
        operationList.add(lastOp);
    }

    @Test
    @DisplayName("测试参数校验 - 工单ID为空")
    void testValidateParam_EoIdNull() {
        wtWorkTicketOperation.setEoId(null);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.updateStatus(wtWorkTicketOperation);
        });
        assertEquals("请选择工单", exception.getMessage());
    }

    @Test
    @DisplayName("测试参数校验 - 操作人ID为空")
    void testValidateParam_OperatorIdNull() {
        wtWorkTicketOperation.setOperatorId(null);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.updateStatus(wtWorkTicketOperation);
        });
        assertEquals("请选择操作人", exception.getMessage());
    }

    @Test
    @DisplayName("测试参数校验 - 操作时间为空")
    void testValidateParam_OperationTimeNull() {
        wtWorkTicketOperation.setOperationTime(null);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.updateStatus(wtWorkTicketOperation);
        });
        assertEquals("请选择操作时间", exception.getMessage());
    }

    @Test
    @DisplayName("测试参数校验 - 操作动作为空")
    void testValidateParam_OperationActNull() {
        wtWorkTicketOperation.setOperationAct(null);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.updateStatus(wtWorkTicketOperation);
        });
        assertEquals("请选择操作动作", exception.getMessage());
    }

    @Test
    @DisplayName("测试参数校验 - 设备ID为空")
    void testValidateParam_EquipmentIdNull() {
        wtWorkTicketOperation.setEquipmentId(null);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.updateStatus(wtWorkTicketOperation);
        });
        assertEquals("请选择设备", exception.getMessage());
    }

    @Test
    @DisplayName("测试无操作记录时的状态转换")
    void testUpdateStatus_NoOperationRecords() {
        // 模拟无操作记录的情况
        when(wtWorkTicketOperationRepository.selectList(wtWorkTicketOperation)).thenReturn(new ArrayList<>());
        // 模拟插入操作
        when(wtWorkTicketOperationRepository.insert(wtWorkTicketOperation)).thenReturn(1);

        // 执行状态更新
        int result = service.updateStatus(wtWorkTicketOperation);

        // 验证结果
        assertEquals(1, result, "插入操作应返回1");
        assertEquals(ProductionStatus.PENDING.getCode(), wtWorkTicketOperation.getPreStatus(), "前置状态应为待处理");
        assertEquals(ProductionStatus.PRODUCING.getCode(), wtWorkTicketOperation.getPostStatus(), "后置状态应为生产中");

        // 验证方法调用
        verify(wtWorkTicketOperationRepository, times(1)).selectList(wtWorkTicketOperation);
        verify(wtWorkTicketOperationRepository, times(1)).insert(wtWorkTicketOperation);
    }

    @Test
    @DisplayName("测试有操作记录时的状态转换")
    void testUpdateStatus_WithOperationRecords() {
        // 模拟有操作记录的情况
        when(wtWorkTicketOperationRepository.selectList(wtWorkTicketOperation)).thenReturn(operationList);
        // 模拟插入操作
        when(wtWorkTicketOperationRepository.insert(wtWorkTicketOperation)).thenReturn(1);

        // 执行状态更新（生产中 → 暂停）
        wtWorkTicketOperation.setOperationAct(WorkOrderProductionAct.PAUSE_PRODUCTION.getValue());
        int result = service.updateStatus(wtWorkTicketOperation);

        // 验证结果
        assertEquals(1, result, "插入操作应返回1");
        assertEquals(ProductionStatus.PRODUCING.getCode(), wtWorkTicketOperation.getPreStatus(), "前置状态应为生产中");
        assertEquals(ProductionStatus.PAUSED.getCode(), wtWorkTicketOperation.getPostStatus(), "后置状态应为已暂停");

        // 验证方法调用
        verify(wtWorkTicketOperationRepository, times(1)).selectList(wtWorkTicketOperation);
        verify(wtWorkTicketOperationRepository, times(1)).insert(wtWorkTicketOperation);
    }

    @Test
    @DisplayName("测试异常状态转换场景")
    void testUpdateStatus_IllegalOperation() {
        // 模拟有操作记录的情况（当前状态为生产中）
        when(wtWorkTicketOperationRepository.selectList(wtWorkTicketOperation)).thenReturn(operationList);

        // 测试非法操作：生产中状态执行开始操作
        wtWorkTicketOperation.setOperationAct(WorkOrderProductionAct.START_PRODUCTION.getValue());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.updateStatus(wtWorkTicketOperation);
        });
        assertEquals("生产已经在进行中，无需再次开始", exception.getMessage());

        // 验证方法调用
        verify(wtWorkTicketOperationRepository, times(1)).selectList(wtWorkTicketOperation);
        verify(wtWorkTicketOperationRepository, times(0)).insert(wtWorkTicketOperation);
    }

    @Test
    @DisplayName("测试完整的状态转换流程")
    void testUpdateStatus_CompleteFlow() {
        // 第一步：待处理 → 生产中
        when(wtWorkTicketOperationRepository.selectList(wtWorkTicketOperation)).thenReturn(new ArrayList<>());
        when(wtWorkTicketOperationRepository.insert(wtWorkTicketOperation)).thenReturn(1);

        wtWorkTicketOperation.setOperationAct(WorkOrderProductionAct.START_PRODUCTION.getValue());
        service.updateStatus(wtWorkTicketOperation);
        assertEquals(ProductionStatus.PRODUCING.getCode(), wtWorkTicketOperation.getPostStatus());

        // 第二步：生产中 → 已暂停
        operationList.get(0).setPostStatus(ProductionStatus.PRODUCING.getCode());
        when(wtWorkTicketOperationRepository.selectList(wtWorkTicketOperation)).thenReturn(operationList);

        wtWorkTicketOperation.setOperationAct(WorkOrderProductionAct.PAUSE_PRODUCTION.getValue());
        service.updateStatus(wtWorkTicketOperation);
        assertEquals(ProductionStatus.PAUSED.getCode(), wtWorkTicketOperation.getPostStatus());

        // 第三步：已暂停 → 生产中
        operationList.get(0).setPostStatus(ProductionStatus.PAUSED.getCode());

        wtWorkTicketOperation.setOperationAct(WorkOrderProductionAct.RESUME_PRODUCTION.getValue());
        service.updateStatus(wtWorkTicketOperation);
        assertEquals(ProductionStatus.PRODUCING.getCode(), wtWorkTicketOperation.getPostStatus());

        // 第四步：生产中 → 已完成
        operationList.get(0).setPostStatus(ProductionStatus.PRODUCING.getCode());

        wtWorkTicketOperation.setOperationAct(WorkOrderProductionAct.COMPLETE_PRODUCTION.getValue());
        service.updateStatus(wtWorkTicketOperation);
        assertEquals(ProductionStatus.COMPLETED.getCode(), wtWorkTicketOperation.getPostStatus());

        // 第五步：已完成 → 已结束
        operationList.get(0).setPostStatus(ProductionStatus.COMPLETED.getCode());

        wtWorkTicketOperation.setOperationAct(WorkOrderProductionAct.END_PRODUCTION.getValue());
        service.updateStatus(wtWorkTicketOperation);
        assertEquals(ProductionStatus.END.getCode(), wtWorkTicketOperation.getPostStatus());

        // 验证方法调用次数
        verify(wtWorkTicketOperationRepository, atLeast(5)).selectList(wtWorkTicketOperation);
        verify(wtWorkTicketOperationRepository, atLeast(5)).insert(wtWorkTicketOperation);
    }

    @Test
    @DisplayName("测试仓库层异常处理")
    void testUpdateStatus_RepositoryException() {
        // 模拟无操作记录的情况（确保状态验证通过）
        when(wtWorkTicketOperationRepository.selectList(wtWorkTicketOperation)).thenReturn(new ArrayList<>());
        // 模拟插入操作抛出异常
        when(wtWorkTicketOperationRepository.insert(wtWorkTicketOperation)).thenThrow(new RuntimeException("数据库插入失败"));

        // 执行状态更新
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.updateStatus(wtWorkTicketOperation);
        });

        // 验证异常信息
        assertEquals("数据库插入失败", exception.getMessage());

        // 验证方法调用
        verify(wtWorkTicketOperationRepository, times(1)).selectList(wtWorkTicketOperation);
        verify(wtWorkTicketOperationRepository, times(1)).insert(wtWorkTicketOperation);
    }
}
