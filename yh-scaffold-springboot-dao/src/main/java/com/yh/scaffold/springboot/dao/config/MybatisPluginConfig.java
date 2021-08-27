package com.yh.scaffold.springboot.dao.config;

import com.yh.common.lark.orm.aop.OffsetLimitInterceptor;
import com.yh.common.lark.orm.aop.QueryAspect;
import com.yh.common.lark.orm.dialect.MySQLDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.lang.reflect.Field;

/**
 * Created by ZhangLei on 2021/8/26.
 */
@Configuration
public class MybatisPluginConfig {


    @Bean
    public OffsetLimitInterceptor getOffsetLimitInterceptor() throws NoSuchFieldException, IllegalAccessException {
        OffsetLimitInterceptor offsetLimitInterceptor=new OffsetLimitInterceptor();
        Field field= offsetLimitInterceptor.getClass().getDeclaredField("dialect");
        field.setAccessible(true);
        field.set(offsetLimitInterceptor,new MySQLDialect());
        return offsetLimitInterceptor;
    }


}
