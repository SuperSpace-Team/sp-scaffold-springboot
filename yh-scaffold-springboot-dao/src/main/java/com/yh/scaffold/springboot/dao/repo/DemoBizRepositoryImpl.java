package com.yh.scaffold.springboot.dao.repo;

import com.yh.scaffold.springboot.api.domain.po.DemoBizPO;
import com.yh.scaffold.springboot.dao.mapper.DemoBizMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: luchao
 * @date: Created in 8/4/21 10:07 PM
 */
@Repository
public class DemoBizRepositoryImpl extends BaseBizRepositoryImpl<DemoBizMapper, DemoBizPO> {

    @Autowired
    private DemoBizRepository demoBizRepository;

    public BaseBizRepository getRepository(){
        return demoBizRepository;
    }

    public List<DemoBizPO> plusTestGetByCode(String code){
        return super.baseMapper.plusTestGetByCode(code);
    }
}
