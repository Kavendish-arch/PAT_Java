package com.chen.dpattern.StatePattern.infra.enums;

/**
 * 任务单生产操作动作枚举
 * 包含：开始、暂停、继续、完成、结束
 */

public enum WorkOrderProductionAct {
    START_PRODUCTION(1, "开始生产"),    // 触发进入生产中
    PAUSE_PRODUCTION(2, "暂停生产"),    // 触发进入已暂停
    RESUME_PRODUCTION(3, "继续生产"),   // 触发从暂停恢复生产中
    COMPLETE_PRODUCTION(5, "完成生产"), // 触发生产中转已完成（新增操作）
    END_PRODUCTION(4, "结束生产");      // 触发终止为已结束

    // 操作值（数据库存储标识）
    private final Integer value;
    // 操作描述（前端展示/日志）
    private final String description;

    WorkOrderProductionAct(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    // 手动实现getter方法
    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 根据操作值获取枚举对象
     * @param value 操作值（如1/2/3）
     * @return 对应枚举，无匹配则抛异常
     */
    public static WorkOrderProductionAct getByValue(Integer value) {
        if (value == null) {
            throw new IllegalArgumentException("操作动作值不能为空");
        }
        for (WorkOrderProductionAct act : values()) {
            if (act.value.equals(value)) {
                return act;
            }
        }
        throw new IllegalArgumentException("未知的生产操作动作值: " + value);
    }
}