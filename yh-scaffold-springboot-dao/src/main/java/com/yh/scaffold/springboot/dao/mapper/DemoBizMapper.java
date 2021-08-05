package com.yh.scaffold.springboot.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yh.scaffold.springboot.api.domain.po.DemoBizPO;

import java.util.List;

/**
 * @description: 业务Mapper类定义
 * @author: luchao
 * @date: Created in 8/4/21 8:41 PM
 */
public interface DemoBizMapper extends BaseMapper<DemoBizPO> {
    /**
     * 自定义查询
     * @return
     */
    List<String> getTestDataList();
}
