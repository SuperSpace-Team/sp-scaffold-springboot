package com.yh.scaffold.springboot.api.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yh.infra.common.base.BasePO;
import com.yh.scaffold.springboot.api.domain.dto.MyBizRequestDTO;
import lombok.Data;

/**
 * @description: demo数据库实体类定义
 * 所有数据库实体类均需以PO结尾,可继承BasePO携带公共数据表字段属性
 * 若类名驼峰格式后和表名不一致,需以@TableName修饰指定,若属性名驼峰格式后和字段名不一致,需以@TableField修饰指定
 * @author: luchao
 * @date: Created in 6/22/21 5:36 PM
 */
@Data
@TableName("test_1")
public class DemoBizPO extends BasePO {
//    /**
//     * 测试属性1
//     */
//    private String testProperty1;
//
//    /**
//     * 测试属性2
//     */
//    private Integer testProperty2;
//
//    /**
//     * 测试属性3
//     */
//    private Boolean testProperty3;
//
//    /**
//     * 测试属性4
//     */
//    private MyBizRequestDTO testProperty4;

    /**
     * 测试编码
     */
    private String code;

    /**
     * 测试名称
     */
    private String name;

    /**
     * 测试描述
     */
    private String description;
}
