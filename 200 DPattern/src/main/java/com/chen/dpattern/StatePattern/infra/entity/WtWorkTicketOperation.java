package com.chen.dpattern.StatePattern.infra.entity;

import java.util.Date;

/**
 * 任务单操作记录实体类 对应数据库工票操作表，存储每一次操作的详细信息
 */
public class WtWorkTicketOperation {

    /**
     * 主键ID
     */
    private Long id;
    /**
     * 工单ID（eoId）
     */
    private String eoId;
    /**
     * 操作人ID
     */
    private Long operatorId;
    /**
     * 操作时间
     */
    private Date operationTime;
    /**
     * 操作动作值（关联WorkOrderProductionAct的value）
     */
    private Integer operationAct;
    /**
     * 设备ID
     */
    private Long equipmentId;
    /**
     * 操作前置状态（关联ProductionStatus的code）
     */
    private String preStatus;
    /**
     * 操作后置状态（关联ProductionStatus的code）
     */
    private String postStatus;
    /**
     * 操作备注
     */
    private String remark;

    // 手动实现getter和setter方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEoId() {
        return eoId;
    }

    public void setEoId(String eoId) {
        this.eoId = eoId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public Integer getOperationAct() {
        return operationAct;
    }

    public void setOperationAct(Integer operationAct) {
        this.operationAct = operationAct;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(String preStatus) {
        this.preStatus = preStatus;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
