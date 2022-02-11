package com.yh.scaffold.springboot.service.user;

import com.yh.common.lark.common.dao.Page;
import com.yh.infra.common.vo.BasePageQueryReqVO;
import com.yh.scaffold.springboot.service.bo.DemoBiz1BO;

import java.util.Map;

/**
 * @description: Demo服务1
 * @author: ${USER}
 * @date: Created in 8/4/21 10:13 PM
 */
public interface DemoBizService1 extends BaseBizService<Long, DemoBiz1BO> {
    /**
     * 普通方法示例
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
     * 普通参数化分页查询
     * @param page
     * @param param
     * @return
     */
    Pagination<DemoBiz1BO> query(Page page, Map<String, Object> param);

    /**
     * 自定义查询示例
     * @param code
     * @return
     */
    List<DemoBiz1BO> plusTestGetByCode(String code);
}
