package com.sp.scaffold.springboot.service.user.impl;

import com.sp.framework.orm.lark.common.dao.Page;
import com.sp.framework.orm.lark.common.dao.Pagination;
import com.sp.framework.orm.lark.common.dao.Sort;
import com.sp.framework.common.utils.bean.DozerUtil;
import com.sp.framework.common.vo.BasePageQueryReqVO;
import com.sp.scaffold.springboot.dao.repo.user.BizDemo1Dao;
import com.sp.scaffold.springboot.dao.repo.user.BizDemo1Repository;
import com.sp.scaffold.springboot.service.bo.DemoBiz1BO;
import com.sp.scaffold.springboot.dao.po.DemoBizPO;
import com.sp.scaffold.springboot.service.base.BaseBizServiceImpl;
import com.sp.scaffold.springboot.service.user.DemoBizService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description: Demo业务Service1实现类
 * @author: ${USER}
 * @date: Created in 8/4/21 10:13 PM
 */
@Service
public class DemoBizService1Impl extends BaseBizServiceImpl<Long, DemoBiz1BO> implements DemoBizService1 {
    @Autowired
    BizDemo1Repository demoBizRepository;

    @Autowired
    BizDemo1Dao bizDemo1Dao;

    @Override
    public Boolean save(DemoBiz1BO bizBO) {
        validate(bizBO);

        DemoBizPO demoBizPO = DozerUtil.map(bizBO, DemoBizPO.class);
        if (demoBizPO.getId() == null) {
            demoBizPO.setVersion(1L);
            return demoBizRepository.save(demoBizPO) ;
        }

        return demoBizRepository.updateById(demoBizPO);
    }

    @Override
    public Pagination<DemoBiz1BO> query(Page page, Map<String, Object> param) {
        Sort[] sorts = new Sort[1];
        sorts[0] = new Sort("modified_at", "DESC");
        return DozerUtil.map(bizDemo1Dao.findListByQueryMapWithPage(page, sorts, param), Pagination.class);
    }

    /**
     * 普通方法示例
     * @return
     */
    @Override
    public String getTest1Result(){
        return "service1-ok";
    }

    /**
     * 分页方法示例
     * 普通场景:Pagination<DemoBizPO>转成Pagination<DemoBizBO>
     * 多表Join分页查询场景: 自定义BO对象接收mapper查询出的结果集,返回Pagination<自定义BO对象>
     * @param basePageQueryVO
     * @return
     */
    @Override
    public Pagination<DemoBiz1BO> getPageDataList(BasePageQueryReqVO basePageQueryVO) {
        return DozerUtil.map(bizDemo1Dao.findListByQueryMapWithPage(basePageQueryVO.getPage(),
                basePageQueryVO.getSorts(), basePageQueryVO.getParams()), Pagination.class);
    }

    @Override
    public List<DemoBiz1BO> plusTestGetByCode(String code) {
        return DozerUtil.mapList(demoBizRepository.queryWithMP(code), DemoBiz1BO.class);
    }
}
