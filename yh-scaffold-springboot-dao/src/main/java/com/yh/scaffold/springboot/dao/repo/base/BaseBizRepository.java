package com.yh.scaffold.springboot.dao.repo.base;

import com.yh.common.lark.common.annotation.QueryPage;
import com.yh.common.lark.common.dao.Page;
import com.yh.common.lark.common.dao.Pagination;
import com.yh.common.lark.common.dao.Sort;
import com.yh.common.lark.orm.dao.supports.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @description: 基础DAO操作仓储接口
 * 集成lark ORM框架
 * @author: ${USER}
 * @date: Created in 7/4/21 4:46 PM
 */
@Repository
public interface BaseBizRepository<ET, PT> extends BaseDao<ET, PT> {
    /**
     * 分页数据查询
     * @param page
     * @param sorts
     * @param params
     * @return
     */
    @QueryPage("findListWithPageCount")
    Pagination<ET> findListByQueryMapWithPage(Page page, Sort[] sorts, Map<String, Object> params);
}
