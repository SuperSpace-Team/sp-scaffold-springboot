package com.yh.scaffold.springboot.service.svc;

import com.yh.infra.common.enums.SystemErrorCodeEnum;
import com.yh.infra.common.exception.BusinessException;
import com.yh.infra.common.utils.bean.DozerUtil;
import com.yh.scaffold.springboot.api.domain.bo.DemoBiz1BO;
import com.yh.scaffold.springboot.api.domain.po.DemoBizPO;
import com.yh.scaffold.springboot.dao.repo.BaseBizRepository;
import com.yh.scaffold.springboot.dao.repo.BaseBizRepositoryImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description: 基础业务Service方法定义
 * @author: luchao
 * @date: Created in 8/4/21 10:02 PM
 */
public interface BaseBizService<KEY, BO> {
    /**
     * 保存记录
     * @param bizBO
     * @return
     */
    Boolean save(BO bizBO);

    /**
     * 启用
     * @param key 主键字段
     * @param operator 操作人
     */
    Boolean enable(KEY key, String operator);

    /**
     * 禁用
     * @param key 主键字段
     * @param operator 操作人
     */
    Boolean disable(KEY key, String operator);
}
