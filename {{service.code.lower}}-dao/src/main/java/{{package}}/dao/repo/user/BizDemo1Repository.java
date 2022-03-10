package {{package}}.dao.repo.user;

import {{package}}.dao.mapper.BizDemoMapper;
import {{package}}.dao.po.DemoBizPO;
import {{package}}.dao.repo.base.BaseBizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: [示例]业务操作仓储类【本文件初版代码可通过代码生成器生成】
 * @author: ${USER}
 * @date: Created in 8/4/21 10:07 PM
 */
@Repository
public class BizDemo1Repository extends BaseBizRepository<BizDemoMapper, com.yh.scaffold.springboot.dao.po.DemoBizPO> {
    @Autowired
    private BizDemo1Dao bizDemoDao;

    @Autowired
    private BizDemoMapper demoBizMapper;

    /**
     * 使用DAO操作
     * @param code
     * @return
     */
    public List<com.yh.scaffold.springboot.dao.po.DemoBizPO> queryWithLarkDao(String code){
        com.yh.scaffold.springboot.dao.po.DemoBizPO criteria = new com.yh.scaffold.springboot.dao.po.DemoBizPO();
        criteria.setCode(code);
        return bizDemoDao.findListByParam(criteria);
    }

    /**
     * 使用Mybatis Plus操作
     * @param code
     * @return
     */
    public List<com.yh.scaffold.springboot.dao.po.DemoBizPO> queryWithMP(String code){
        return demoBizMapper.queryWithMP(code);
    }

}
