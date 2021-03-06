package com.sp.scaffold.springboot.dao.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.sp.framework.orm.lark.orm.aop.OffsetLimitInterceptor;
import com.sp.framework.orm.lark.orm.aop.QueryAspect;
import com.sp.framework.orm.lark.orm.dialect.MySQLDialect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @description: Mybatis-Plus相关配置
 * @author: admin
 * @date: Created in 10/27/21 8:01 PM
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"com.sp.scaffold.springboot.dao"})
public class MybatisPlusConfig {
    /**
     * 配置MybatisPlus原生分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 配置lark ORM框架分页/排序插件
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Bean
    public OffsetLimitInterceptor getOffsetLimitInterceptor() throws NoSuchFieldException, IllegalAccessException {
        OffsetLimitInterceptor offsetLimitInterceptor=new OffsetLimitInterceptor();
        Field field= offsetLimitInterceptor.getClass().getDeclaredField("dialect");
        field.setAccessible(true);
        field.set(offsetLimitInterceptor,new MySQLDialect());
        return offsetLimitInterceptor;
    }
}
