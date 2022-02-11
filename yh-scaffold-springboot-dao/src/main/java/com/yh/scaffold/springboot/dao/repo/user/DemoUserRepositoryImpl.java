package com.yh.scaffold.springboot.dao.repo.user;

import com.yh.scaffold.springboot.dao.po.DemoBizPO;
import com.yh.scaffold.springboot.dao.mapper.DemoUserMapper;
import com.yh.scaffold.springboot.dao.repo.base.BaseBizRepository;
import com.yh.scaffold.springboot.dao.repo.base.BaseBizRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: [示例]业务操作仓储实现类【本文件初版代码可通过代码生成器生成】
 * @author: ${USER}
 * @date: Created in 8/4/21 10:07 PM
 */
@Repository
public class DemoUserRepositoryImpl extends BaseBizRepositoryImpl<DemoUserMapper, DemoBizPO> {

    @Autowired
    private DemoUserRepository demoBizRepository;

    @Override
    public BaseBizRepository getRepository(){
        return demoBizRepository;
    }

    public List<DemoBizPO> plusTestGetByCode(String code){
        return super.baseMapper.plusTestGetByCode(code);
    }
}
