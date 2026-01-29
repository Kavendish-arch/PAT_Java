package com.chen.dpattern.StatePattern.infra.enums;

/**
 * 任务单生产状态枚举
 * 包含：待处
 理、
生产中、已暂停、已完成、已结束
 */
public enum ProductionStatus {
    PENDING("待处理"),    // 初始状态，无操作记录
    PRODUCING("生产中"),  // 正在生产核心状态
    PAUSED("已暂停"),     // 生产临时中断，可恢复
    COMPLETED("已完成"),  // 正常完工（新增状态）
    END("已结束");        // 强制/异常终止，可重启

    // 状态编码（前端展示/数据库存储）
    private final String code;

    ProductionStatus(String code) {
        this.code = code;
    }

    // 手动实现getter方法
    public String getCode() {
        return code;
    }

    /**
     * 根据状态编码获取枚举对象
     * @param code 状态编码（如"生产中"）
     * @return 对应枚举，无匹配则抛异常
     */
    public static ProductionStatus getByCode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("状态编码不能为空");
        }
        for (ProductionStatus status : values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("未知的生产状态编码: " + code);
    }
}