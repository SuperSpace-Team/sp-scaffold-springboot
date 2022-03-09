package com.yh.scaffold.springboot.service.user;

import com.yh.scaffold.springboot.service.base.BaseBizService;
import com.yh.scaffold.springboot.service.bo.DemoBiz2BO;

/**
 * @description: Demo服务2
 * @author: ${USER}
 * @date: Created in 8/4/21 10:13 PM
 */
public interface DemoBizService2 extends BaseBizService<Long, DemoBiz2BO> {
    /**
     * 普通方法示例2
     * @return
     */
    String getTest2Result();
}
