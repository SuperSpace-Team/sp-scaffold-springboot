package com.yh.scaffold.springboot.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yh.scaffold.springboot.api.domain.po.DemoBizPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @description: 业务Mapper类定义
 * @author: luchao
 * @date: Created in 8/4/21 8:41 PM
 */
public interface DemoBizMapper extends BaseMapper<DemoBizPO> {

    List<DemoBizPO> plusTestGetByCode(@Param("code") String code);

}
