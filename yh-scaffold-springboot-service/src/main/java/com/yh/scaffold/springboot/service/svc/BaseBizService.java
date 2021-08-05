package com.yh.scaffold.springboot.service.svc;

/**
 * @description:
 * @author: luchao
 * @date: Created in 8/4/21 10:02 PM
 */
public interface BaseBizService<KEY, BO> {

    /**
     * 创建/修改记录
     * @param bo BO对象
     */
    Boolean save(BO bo);

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
