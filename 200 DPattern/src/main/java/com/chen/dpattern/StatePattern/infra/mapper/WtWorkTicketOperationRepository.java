package com.chen.dpattern.StatePattern.infra.mapper;

import java.util.List;

import com.chen.dpattern.StatePattern.infra.entity.WtWorkTicketOperation;

/**
 * 任务单操作记录仓库层（Mapper/DAO） 负责数据库的增、查操作
 */
public interface WtWorkTicketOperationRepository {

    /**
     * 根据条件查询操作记录列表（按操作时间倒序）
     *
     * @param wtWorkTicketOperation 查询条件（如eoId工单ID）
     * @return 操作记录列表
     */
    List<WtWorkTicketOperation> selectList(WtWorkTicketOperation wtWorkTicketOperation);

    /**
     * 插入新的操作记录
     *
     * @param wtWorkTicketOperation 操作记录
     * @return 数据库影响行数
     */
    int insert(WtWorkTicketOperation wtWorkTicketOperation);
}
