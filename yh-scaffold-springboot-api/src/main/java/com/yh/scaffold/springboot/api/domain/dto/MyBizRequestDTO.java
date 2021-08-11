package com.yh.scaffold.springboot.api.domain.dto;

import com.yh.infra.common.dto.BaseRequestDTO;
import lombok.Data;

/**
 * @description: demo业务DTO定义
 * 需以DTO结尾,可继承BaseRequestDTO携带公共属性
 * @author: luchao
 * @date: Created in 6/22/21 5:36 PM
 */
@Data
public class MyBizRequestDTO extends BaseRequestDTO {
    /**
     * 测试业务属性1
     */
    private String testBizProperty1;

    /**
     * 测试业务属性2
     */
    private Integer testBizProperty2;
}
