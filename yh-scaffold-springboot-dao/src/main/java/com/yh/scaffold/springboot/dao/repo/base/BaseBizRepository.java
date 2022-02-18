package com.yh.scaffold.springboot.dao.repo.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @description: 【非必需】公共仓储实现类
 * 兼容集成Mybatis-Plus框架基类方法
 * @author: admin
 * @date: Created in 7/4/21 8:07 PM
 */
public abstract class BaseBizRepository<MP extends BaseMapper<PO>, PO> extends ServiceImpl<MP, PO> {

}
