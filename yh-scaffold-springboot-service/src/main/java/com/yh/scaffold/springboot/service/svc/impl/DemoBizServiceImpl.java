package com.yh.scaffold.springboot.service.svc.impl;

import com.yh.scaffold.springboot.dao.repo.DemoBizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: luchao
 * @date: Created in 8/4/21 10:13 PM
 */
@Service
public class DemoBizServiceImpl extends BaseBizServiceImpl {
    @Autowired
    DemoBizRepository demoBizRepository;

    @Override
    public Boolean save(Object o) {
        return super.save(o);
    }

    @Override
    public Boolean enable(Object o, String operator) {
        return super.enable(o, operator);
    }

    @Override
    public Boolean disable(Object o, String operator) {
        return super.disable(o, operator);
    }
}
