package com.yh.scaffold.springboot.dao.repo.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @description: 基础仓储实现类
 * 集成Mybatis-Plus基类方法
 * @author: ${USER}
 * @date: Created in 7/4/21 8:07 PM
 */
public abstract class BaseBizRepositoryImpl<MP extends BaseMapper<PO>, PO> extends ServiceImpl<MP, PO> {
    public abstract BaseBizRepository getRepository();

}
