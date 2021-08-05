package com.yh.scaffold.springboot.api.domain.po;

import com.yh.infra.common.base.BasePO;
import com.yh.scaffold.springboot.domain.dto.MyBizRequestDTO;
import lombok.Data;

/**
 * @description: demo数据库实体类定义
 * 需以PO结尾,可继承BasePO携带公共数据表字段属性
 * @author: luchao
 * @date: Created in 6/22/21 5:36 PM
 */
@Data
public class DemoBizPO extends BasePO {
    /**
     * 测试属性1
     */
    private String testProperty1;

    /**
     * 测试属性2
     */
    private Integer testProperty2;

    /**
     * 测试属性3
     */
    private Boolean testProperty3;

    /**
     * 测试属性4
     */
    private MyBizRequestDTO testProperty4;
}
