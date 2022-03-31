package com.yh.scaffold.springboot.api.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @description: [示例]普通查询响应VO类定义
 * @author: luchao
 * @date: Created in 3/31/22 6:01 PM
 */
@Data
@AllArgsConstructor
public class DemoPlusTestResp {
    /**
     * 测试数据列表
     */
    List<DemoBiz1VO> dataList;
}
