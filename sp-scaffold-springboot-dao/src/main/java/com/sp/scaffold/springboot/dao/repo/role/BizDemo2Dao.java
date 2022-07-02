package com.sp.scaffold.springboot.dao.repo.role;

import com.sp.framework.orm.lark.common.annotation.QueryPage;
import com.sp.framework.orm.lark.common.dao.Page;
import com.sp.framework.orm.lark.common.dao.Pagination;
import com.sp.framework.orm.lark.common.dao.Sort;
import com.sp.framework.orm.lark.orm.dao.supports.BaseDao;
import com.sp.scaffold.springboot.dao.po.DemoBizPO;
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
