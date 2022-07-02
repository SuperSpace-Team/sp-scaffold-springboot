package {{package}}.service.user.impl;

import com.sp.framework.common.utils.bean.DozerUtil;
import {{package}}.dao.repo.role.BizDemo2Dao;
import {{package}}.dao.repo.role.BizDemo2Repository;
import {{package}}.service.bo.DemoBiz2BO;
import {{package}}.dao.po.DemoBizPO;
import {{package}}.service.base.BaseBizServiceImpl;
import {{package}}.service.user.DemoBizService2;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description: Demo业务Service2实现类
 * @author: ${USER}
 * @date: Created in 10/27/21 7:03 PM
 */
public class DemoBizService2Impl extends BaseBizServiceImpl<Long, DemoBiz2BO> implements DemoBizService2 {
    @Autowired
    BizDemo2Repository demoBizRepository;

    @Autowired
    BizDemo2Dao bizDemo2Dao;

    /**
     * 普通方法示例
     * @return
     */
    @Override
    public String getTest2Result(){
        return "service2-ok";
    }

    @Override
    public Boolean save(DemoBiz2BO bizBO) {
        validate(bizBO);

        DemoBizPO demoBizPO = DozerUtil.map(bizBO, DemoBizPO.class);
        if (bizBO.getId() == null) {
            bizBO.setVersion(1L);
            return demoBizRepository.save(demoBizPO) ;
        }

        return demoBizRepository.updateById(demoBizPO);
    }
}
