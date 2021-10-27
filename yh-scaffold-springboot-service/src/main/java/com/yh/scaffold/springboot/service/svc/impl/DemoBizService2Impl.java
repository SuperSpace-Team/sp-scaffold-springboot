package com.yh.scaffold.springboot.service.svc.impl;

import com.yh.infra.common.utils.bean.DozerUtil;
import com.yh.scaffold.springboot.api.domain.bo.DemoBiz1BO;
import com.yh.scaffold.springboot.api.domain.bo.DemoBiz2BO;
import com.yh.scaffold.springboot.api.domain.po.DemoBizPO;
import com.yh.scaffold.springboot.dao.repo.DemoBizRepositoryImpl;
import com.yh.scaffold.springboot.service.svc.DemoBizService2;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: Demo业务Service2实现类
 * @author: luchao
 * @date: Created in 10/27/21 7:03 PM
 */
public class DemoBizService2Impl extends BaseBizServiceImpl<Long, DemoBiz2BO> implements DemoBizService2 {
    @Autowired
    DemoBizRepositoryImpl demoBizRepository;

    /**
     * 普通方法示例
     * @return
     */
    @Override
    public String getTest2Result(){
        return "service2-ok";
    }

    @Override
    public Boolean save(DemoBiz2BO bizBO) {
        validate(bizBO);

        DemoBizPO demoBizPO = DozerUtil.map(bizBO, DemoBizPO.class);
        if (bizBO.getId() == null) {
            bizBO.setVersion(1L);
            return demoBizRepository.save(demoBizPO) ;
        }

        return demoBizRepository.updateById(demoBizPO);
    }
}
