package com.yh.scaffold.springboot.api.domain.bo;

import com.yh.infra.common.bo.BaseBO;
import lombok.Data;

import java.util.List;

/**
 * @description: Demo业务1对象
 * @author: luchao
 * @date: Created in 8/4/21 10:17 PM
 */
@Data
public class DemoBiz1BO extends BaseBO {
    /**
     * 测试属性1
     */
    private List<String> dataList;

    /**
     * 测试属性2
     */
    private Integer testCount;

    /**
     * 测试属性1
     */
    private String testProperty1;

    /**
     * 测试属性2
     */
    private Integer testProperty2;

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