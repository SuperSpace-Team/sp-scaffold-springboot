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
public class BaseBizRepositoryImpl<MP extends BaseMapper<PO>, PO> extends ServiceImpl<MP, PO> {
    @Autowired
    private MP mapper;

//    /**
//     * 根据Map条件查询列表数据
//     * @param map
//     * @return
//     */
//    public List<PO> getList(Map<String, Object> map) {
//        return mapper.selectByMap(map);
//    }
}
