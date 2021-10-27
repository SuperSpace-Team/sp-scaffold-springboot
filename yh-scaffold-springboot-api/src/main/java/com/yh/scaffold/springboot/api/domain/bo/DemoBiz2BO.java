package com.yh.scaffold.springboot.api.domain.bo;

import com.yh.infra.common.bo.BaseBO;
import lombok.Data;

import java.util.List;

/**
 * @description: Demo业务2对象
 * @author: luchao
 * @date: Created in 8/4/21 10:17 PM
 */
@Data
public class DemoBiz2BO extends BaseBO {
    /**
     * 测试属性列表
     */
    private List<String> dataList2;

    /**
     * 测试2属性
     */
    private String test2Property;
}
