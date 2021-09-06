package com.yh.scaffold.springboot.domain.vo;

import com.yh.infra.common.vo.BasePageQueryReqVO;
import com.yh.scaffold.springboot.api.domain.dto.MyBizRequestDTO;
import lombok.Data;

/**
 * @description: demo API请求DTO定义
 * 需以DTO结尾,可继承BaseRequestDTO携带公共属性
 * @author: luchao
 * @date: Created in 6/22/21 5:36 PM
 */
@Data
public class DemoApiRequestVO extends BasePageQueryReqVO {
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
