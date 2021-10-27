package com.yh.scaffold.springboot.service.svc;

import com.yh.scaffold.springboot.api.domain.bo.DemoBiz1BO;
import com.yh.scaffold.springboot.api.domain.bo.DemoBiz2BO;

/**
 * @description: Demo服务2
 * @author: luchao
 * @date: Created in 8/4/21 10:13 PM
 */
public interface DemoBizService2 extends BaseBizService<Long, DemoBiz2BO> {
    /**
     * 普通方法示例2
     * @return
     */
    String getTest2Result();
}
