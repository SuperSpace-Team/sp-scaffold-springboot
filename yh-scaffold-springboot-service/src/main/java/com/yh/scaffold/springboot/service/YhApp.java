package com.yh.scaffold.springboot.service;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

/**
 * 启动类
 *
 * @author luchao
 * @date 2020/7/2
 */
@SpringBootApplication(scanBasePackages = {"com.yh.scaffold.springboot", "com.yh.infra.comp", "com.baomidou"})
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableApolloConfig
@EnableFeignClients(basePackages = "com.yh.scaffold.springboot.api")
@EntityScan(basePackages = "com.yh.scaffold.springboot.api.*")
@MapperScan("com.yh.scaffold.springboot.dao")
public class YhApp {
    public static void main(String[] args) {
        SpringApplication.run(YhApp.class, args);
    }
}
