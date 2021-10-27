package com.yh.scaffold.springboot.service.svc;

import com.yh.common.lark.common.dao.Page;
import com.yh.common.lark.common.dao.Pagination;
import com.yh.infra.common.vo.BasePageQueryReqVO;
import com.yh.scaffold.springboot.api.domain.bo.DemoBiz1BO;

import java.util.List;
import java.util.Map;

/**
 * @description: Demo服务1
 * @author: luchao
 * @date: Created in 8/4/21 10:13 PM
 */
public interface DemoBizService1 extends BaseBizService<Long, DemoBiz1BO> {
    /**
     * 普通方法示例1
     * @return
     */
    String getTest1Result();

    /**
     * 分页方法示例
     * @param basePageQueryVO
     * @return
     */
    Pagination<DemoBiz1BO> getPageDataList(BasePageQueryReqVO basePageQueryVO);

    /**
     * 普通分页查询
     * @param page
     * @param param
     * @return
     */
    Pagination<DemoBiz1BO> query(Page page, Map<String, Object> param);

    List<DemoBiz1BO> plusTestGetByCode(String code);

}
