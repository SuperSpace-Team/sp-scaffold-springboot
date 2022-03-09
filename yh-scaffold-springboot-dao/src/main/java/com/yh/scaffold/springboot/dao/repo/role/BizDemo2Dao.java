package com.yh.scaffold.springboot.dao.repo.role;

import com.yh.common.lark.common.annotation.QueryPage;
import com.yh.common.lark.common.dao.Page;
import com.yh.common.lark.common.dao.Pagination;
import com.yh.common.lark.common.dao.Sort;
import com.yh.common.lark.orm.dao.supports.BaseDao;
import com.yh.scaffold.springboot.dao.po.DemoBizPO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @description: 【示例】业务常用Dao操作
 * 集成lark ORM框架,继承BaseDao基类,对应classpath:mapper/BizDemo1Dao.xml
 * @author: ${USER}
 * @date: Created in 7/4/21 4:46 PM
 */
@Component
public interface BizDemo2Dao extends BaseDao<DemoBizPO, Long> {
    /**
     * 分页数据查询
     * @param page
     * @param sorts
     * @param params
     * @return
     */
    @QueryPage("findListCountByQueryMap")
    Pagination<DemoBizPO> findListByQueryMapWithPage(Page page, Sort[] sorts, Map<String, Object> params);
}
