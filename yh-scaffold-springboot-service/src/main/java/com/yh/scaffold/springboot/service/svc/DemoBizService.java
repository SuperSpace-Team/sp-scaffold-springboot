package com.yh.scaffold.springboot.service.svc;

import com.yh.common.lark.common.dao.Page;
import com.yh.common.lark.common.dao.Pagination;
import com.yh.scaffold.springboot.api.domain.vo.BasePageQueryReqVO;
import com.yh.scaffold.springboot.api.domain.vo.DemoApiPageRespVO;
import com.yh.scaffold.springboot.api.domain.bo.DemoBizBO;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: luchao
 * @date: Created in 8/4/21 10:13 PM
 */
public interface DemoBizService extends BaseBizService<Long, DemoBizBO> {
    /**
     * 普通方法示例
     * @return
     */
    Boolean getTestGetResult();

    /**
     * 分页方法示例
     * @param basePageQueryVO
     * @return
     */
    Pagination<DemoBizBO> getPageDataList(BasePageQueryReqVO basePageQueryVO);

    /**
     * 普通分页查询
     * @param page
     * @param param
     * @return
     */
    Pagination<DemoBizBO> query(Page page, Map<String, Object> param);

    List<DemoBizBO> plusTestGetByCode(String code);

}
