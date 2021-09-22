package com.yh.scaffold.springboot.service.svc.impl;

import com.yh.common.lark.orm.dao.supports.BaseDao;
import com.yh.infra.common.bo.BaseBO;
import com.yh.infra.common.enums.SystemErrorCodeEnum;
import com.yh.infra.common.exception.BusinessException;
import com.yh.infra.comp.core.validator.BizValidationManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 基础业务实现类
 * 用于放置可复用代码,适合大部分的manager,但也有少数manager需要进行定制,KEY不是表的ID,
 * 一般来说是业务code或具有联合主键的属性/字段,所以需要定制化getModelByCode.
 * @author: luchao
 * @date: Created in 8/4/21 10:05 PM
 */
@Slf4j
@Service
public class BaseBizServiceImpl<KEY, MODEL extends BaseBO> { //implements BaseBizService {
    @Autowired
    BizValidationManager validationManager;

    /**
     * 取得model对应的表名
     * @return
     */
    protected String getTableName() {
        throw new BusinessException("NOT IMPLEMENTED.");
    };

    /**
     * 取得DAO对象
     *
     * @return
     */
    protected BaseDao<MODEL, Long> getDao() {
        throw new RuntimeException("NOT IMPLEMENTED.");
    };

    /**
     * 根据编码从DB中查询到PO实体
     * 适用于有业务编码字段的记录查询
     * @param code
     * @return
     */
    protected MODEL getModelByCode(Integer code) {
        throw new RuntimeException("NOT IMPLEMENTED.");
    };

    /**
     * 校验数据
     *
     * @param model
     * @return
     */
    protected void validate(MODEL model) {
        List<Error> errors = validationManager.validate(model);
        if (CollectionUtils.isNotEmpty(errors)) {
            throw new BusinessException(
                    SystemErrorCodeEnum.DATA_ENROLL_DB_ERROR.getCode(), errors.get(0).getMessage());
        }
    }

    /**
     * 通用更新操作
     *
     * @param model
     */
    public Boolean update(MODEL model) {
        //经各校验器检查
        validate(model);

        if (model.getId() == null) {
            model.setVersion(1L);

            try {
                return getDao().insert(model) > 0;
            } catch (Exception e) {
                log.warn("BaseManagerImpl update error e="+e);
                if (e instanceof DuplicateKeyException) {
                    throw new BusinessException(SystemErrorCodeEnum.DATA_ENROLL_DB_ERROR.getCode(),
                            "数据库中存在重复数据，请确保业务代码、名称等字段唯一存在" + model.getId());
                } else {
                    throw new BusinessException(SystemErrorCodeEnum.DATA_ENROLL_DB_ERROR.getCode(),
                            SystemErrorCodeEnum.DATA_ENROLL_DB_ERROR.getMsg() + "请重试" + model.getId());
                }
            }
        }

        try {
            int ret = getDao().update(model);
            if (ret == 0) {
                throw new BusinessException(SystemErrorCodeEnum.DATA_ENROLL_DB_ERROR.getCode(),
                        "无法更新数据，可能是数据过期。" + model.getId());
            }
        } catch (Exception e) {
            log.warn("BaseManagerImpl update error:"+e);
            if (e instanceof DuplicateKeyException) {
                throw new BusinessException(SystemErrorCodeEnum.DATA_ENROLL_DB_ERROR.getCode(),
                        "数据库中存在重复数据，请确保记录唯一存在" + model.getId());
            } else {
                throw new BusinessException(SystemErrorCodeEnum.DATA_ENROLL_DB_ERROR.getCode(),
                        SystemErrorCodeEnum.DATA_ENROLL_DB_ERROR.getMsg() + "请重试" + model.getId());
            }
        }

        return true;
    }

    public Boolean enable(KEY key, String operator) {
//        MODEL model = getDao().findListByQueryMap(key);
//        return getDao().update();
        return true;
    }

    public Boolean disable(KEY key, String operator) {
//        changeStatus(key, operator, false);
        return true;
    }

//    /**
//     * 更新记录的业务状态值
//     * @param key
//     * @param operator
//     * @param newStatus
//     * @return
//     */
//    protected Boolean changeStatus(KEY key, String operator, Boolean newStatus) {
//        Integer code = (Integer) key;
//        MODEL model = getModelByCode(code);
//        // 已经是目标状态，不需要更改
//        if (newStatus.equals(model.getLifecycle())) {
//            return true;
//        }
//
//        int update = bizDao.changeLifecycle(getTableName(), code, operator, newStatus, model.getVersion());
//        // 更新成功
//        if (update != 1) {
//            model = getModelByCode(code);
//            // 被别人更新了,不需要更新 版本号
//            if (newStatus.equals(model.getLifecycle())) {
//                return true;
//            }
//
//            // 更新失败
//            if (update == 0) {
//                throw new BusinessException(SystemErrorCodeEnum.DATA_ENROLL_DB_ERROR.getCode(), "无法更新状态为" + newStatus);
//            }
//        }
//        return true;
//    }
}
