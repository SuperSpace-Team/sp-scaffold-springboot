package com.yh.scaffold.springboot.dao.repo;

import com.yh.scaffold.springboot.api.domain.po.DemoBizPO;
import com.yh.scaffold.springboot.dao.mapper.DemoBizMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: luchao
 * @date: Created in 8/4/21 10:07 PM
 */
@Repository
public interface DemoBizRepository extends BaseBizRepository<DemoBizMapper, Long> {
    /**
     * 测试查询方法
     * @return
     */
    List<DemoBizPO> getTestDataList();
}
