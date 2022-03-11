package {{package}}.dao.repo.user;

import com.yh.common.lark.common.annotation.QueryPage;
import com.yh.common.lark.common.dao.Page;
import com.yh.common.lark.common.dao.Pagination;
import com.yh.common.lark.common.dao.Sort;
import com.yh.common.lark.orm.dao.supports.BaseDao;
import org.springframework.stereotype.Component;
import {{package}}.dao.po.DemoBizPO;

import java.util.Map;

/**
 * @description: 【示例】业务常用Dao操作
 * 集成lark ORM框架,继承BaseDao基类,对应classpath:mapper/BizDemo1Dao.xml
 * @author: ${USER}
 * @date: Created in 7/4/21 4:46 PM
 */
@Component
public interface BizDemo1Dao extends BaseDao<com.yh.scaffold.springboot.dao.po.DemoBizPO, Long> {
    /**
     * 分页数据查询
     * @param page
     * @param sorts
     * @param params
     * @return
     */
    @QueryPage("findListCountByQueryMap")
    Pagination<com.yh.scaffold.springboot.dao.po.DemoBizPO> findListByQueryMapWithPage(Page page, Sort[] sorts, Map<String, Object> params);
}