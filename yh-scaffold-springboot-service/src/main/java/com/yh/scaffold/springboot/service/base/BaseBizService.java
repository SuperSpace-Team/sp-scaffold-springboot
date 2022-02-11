package com.yh.scaffold.springboot.service.base;

/**
 * @description: [推荐,非必须]基础业务Service方法定义
 * @author: ${USER}
 * @date: Created in 8/4/21 10:02 PM
 */
public interface BaseBizService<KEY, BO> {
    /**
     * 保存记录
     * @param bizBO
     * @return
     */
    Boolean save(BO bizBO);

    /**
     * 启用
     * @param key 主键字段
     * @param operator 操作人
     */
    Boolean enable(KEY key, String operator);

    /**
     * 禁用
     * @param key 主键字段
     * @param operator 操作人
     */
    Boolean disable(KEY key, String operator);
}
