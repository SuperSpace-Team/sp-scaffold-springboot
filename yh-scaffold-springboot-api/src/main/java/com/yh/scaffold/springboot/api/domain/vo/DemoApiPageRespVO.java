package com.yh.scaffold.springboot.api.domain.vo;

import com.yh.infra.common.dto.BaseResponseDTO;
import lombok.Data;

import java.util.List;

/**
 * @description: 测试分页返回VO类
 * @author: luchao
 * @date: Created in 8/5/21 3:01 PM
 */
@Data
public class DemoApiPageRespVO extends BasePageQueryRespVO {
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
