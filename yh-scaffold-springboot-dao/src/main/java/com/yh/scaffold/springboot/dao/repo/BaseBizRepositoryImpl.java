package com.yh.scaffold.springboot.dao.repo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @description: 基础仓储实现类
 * 集成Mybatis-Plus基类方法
 * @author: luchao
 * @date: Created in 7/4/21 8:07 PM
 */
public abstract class BaseBizRepositoryImpl<MP extends BaseMapper<PO>, PO> extends ServiceImpl<MP, PO> {

    public abstract BaseBizRepository getRepository();

}
