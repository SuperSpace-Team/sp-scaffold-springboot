package com.yh.scaffold.springboot.server;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 *
 * @author ${USER}
 * @date 2020/7/2
 */
@SpringBootApplication(scanBasePackages = {"com.yh.scaffold.springboot", "com.yh.infra.comp", "com.baomidou", "com.yh.infra"})
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableApolloConfig
@EnableFeignClients(basePackages = "com.yh.scaffold.springboot.feign")
public class YhApp {
    public static void main(String[] args) {
        SpringApplication.run(YhApp.class, args);
    }
}
