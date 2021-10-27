package com.yh.scaffold.springboot.service.biz;

import com.yh.scaffold.springboot.service.svc.DemoBizService1;
import com.yh.scaffold.springboot.service.svc.DemoBizService2;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: Demo业务聚合层
 * @author: luchao
 * @date: Created in 10/27/21 7:01 PM
 */
public class DemoBiz {
    @Autowired
    DemoBizService1 demoBizService1;

    @Autowired
    DemoBizService2 demoBizService2;

    public String aggregateMethod1(){
        return demoBizService1.getTest1Result() + demoBizService2.getTest2Result();
    }
}
