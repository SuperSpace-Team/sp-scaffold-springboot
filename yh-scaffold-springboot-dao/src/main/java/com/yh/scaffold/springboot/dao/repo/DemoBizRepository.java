package com.yh.scaffold.springboot.dao.repo;

import com.yh.scaffold.springboot.api.domain.po.DemoBizPO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: 业务操作仓储接口
 * @author: luchao
 * @date: Created in 8/4/21 10:07 PM
 */
@Component
public interface DemoBizRepository extends BaseBizRepository<DemoBizPO, Long> {
//    /**
//     * 测试查询方法
//     * @return
//     */
//    List<DemoBizPO> getTestDataList();
}
