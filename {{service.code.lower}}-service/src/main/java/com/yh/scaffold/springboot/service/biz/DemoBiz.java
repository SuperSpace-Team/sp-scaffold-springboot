package com.yh.scaffold.springboot.service.biz;

import com.yh.scaffold.springboot.service.user.DemoBizService1;
import com.yh.scaffold.springboot.service.user.DemoBizService2;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: [示例,非必须]业务聚合Demo
 * @author: ${USER}
 * @date: Created in 10/27/21 7:01 PM
 */
public class DemoBiz {
    @Autowired
    DemoBizService1 demoBizService1;

    @Autowired
    DemoBizService2 demoBizService2;

    public String getAggregateResultTest(){
        return demoBizService1.getTest1Result() + demoBizService2.getTest2Result();
    }
}
