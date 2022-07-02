package com.sp.scaffold.springboot.api.domain.dto;

import com.sp.framework.common.dto.BaseRequestDTO;
import lombok.Data;

/**
 * @description: [示例]业务请求DTO定义
 * 需以DTO结尾,可继承BaseRequestDTO携带公共属性
 * @author: ${USER}
 * @date: Created in 6/22/21 5:36 PM
 */
@Data
public class MyBizReqDTO extends BaseRequestDTO {
    /**
     * 测试业务属性1
     */
    private String testBizProperty1;

    /**
     * 测试业务属性2
     */
    private Integer testBizProperty2;
}
