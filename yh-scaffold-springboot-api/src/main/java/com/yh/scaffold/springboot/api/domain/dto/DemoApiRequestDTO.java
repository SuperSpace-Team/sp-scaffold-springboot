package com.yh.scaffold.springboot.api.domain.dto;

import com.yh.infra.common.dto.BaseRequestDTO;
import lombok.Data;

/**
 * @description: demo API请求DTO定义
 * 需以DTO结尾,可继承BaseRequestDTO携带公共属性
 * @author: luchao
 * @date: Created in 6/22/21 5:36 PM
 */
@Data
public class DemoApiRequestDTO extends BaseRequestDTO {
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
