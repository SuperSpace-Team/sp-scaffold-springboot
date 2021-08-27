package com.yh.scaffold.springboot.service.svc.impl;

import com.yh.common.lark.common.dao.Page;
import com.yh.common.lark.common.dao.Pagination;
import com.yh.common.lark.common.dao.Sort;
import com.yh.common.lark.orm.aop.QueryAspect;
import com.yh.infra.common.utils.bean.DozerUtil;
import com.yh.scaffold.springboot.api.domain.bo.DemoBizBO;
import com.yh.scaffold.springboot.api.domain.po.DemoBizPO;
import com.yh.scaffold.springboot.api.domain.vo.BasePageQueryReqVO;
import com.yh.scaffold.springboot.dao.repo.BaseBizRepository;
import com.yh.scaffold.springboot.dao.repo.DemoBizRepositoryImpl;
import com.yh.scaffold.springboot.service.svc.DemoBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: luchao
 * @date: Created in 8/4/21 10:13 PM
 */
@Service
public class DemoBizServiceImpl extends BaseBizServiceImpl<Long, DemoBizBO> implements DemoBizService {
    @Autowired
    DemoBizRepositoryImpl demoBizRepository;

    @Override
    public Boolean save(DemoBizBO bizBO) {
        validate(bizBO);

        DemoBizPO demoBizPO = DozerUtil.map(bizBO, DemoBizPO.class);
        if (bizBO.getId() == null) {
            bizBO.setVersion(1L);
            return demoBizRepository.save(demoBizPO) ;
        }

        return demoBizRepository.updateById(demoBizPO);
    }

    @Override
    public Pagination<DemoBizBO> query(Page page, Map<String, Object> param) {
        Sort[] sorts = new Sort[1];
//	sorts[0] = new Sort("app_id", "ASC");
//	sorts[1] = new Sort("biz_code", "ASC");
        sorts[0] = new Sort("modified_at", "DESC");
        return DozerUtil.map(demoBizRepository.getRepository().findListByQueryMapWithPage(page, sorts, param), Pagination.class);
    }

    /**
     * 普通方法示例
     * @return
     */
    @Override
    public Boolean getTestGetResult(){
        return true;
    }

    /**
     * 分页方法示例
     * 普通场景:Pagination<DemoBizPO>转成Pagination<DemoBizBO>
     * 多表Join分页查询场景: 自定义BO对象接收mapper查询出的结果集,返回Pagination<自定义BO对象>
     * @param basePageQueryVO
     * @return
     */
    @Override
    public Pagination<DemoBizBO> getPageDataList(BasePageQueryReqVO basePageQueryVO) {
        return DozerUtil.map(demoBizRepository.getRepository().findListByQueryMapWithPage(basePageQueryVO.getPage(),
                basePageQueryVO.getSorts(), basePageQueryVO.getParams()), Pagination.class);
    }

    @Override
    public List<DemoBizBO> plusTestGetByCode(String code) {
        return DozerUtil.mapList(demoBizRepository.plusTestGetByCode(code), DemoBizBO.class);
    }
}
