package com.yh.scaffold.springboot.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yh.scaffold.springboot.dao.po.DemoBizPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @description: [示例]业务Mapper类定义【本文件初版代码可通过代码生成器生成】
 * @author: ${USER}
 * @date: Created in 8/4/21 8:41 PM
 */
public interface DemoUserMapper extends BaseMapper<DemoBizPO> {

    List<DemoBizPO> plusTestGetByCode(@Param("code") String code);

}
