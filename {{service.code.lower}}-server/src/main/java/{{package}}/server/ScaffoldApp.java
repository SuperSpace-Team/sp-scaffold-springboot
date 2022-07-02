package {{package}}.server;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 启动类
 *
 * @author ${USER}
 * @date 2020/7/2
 */
@SpringBootApplication(scanBasePackages = { "{{package}}", "com.sp.infra.comp", "com.baomidou", "com.sp.infra"})
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableApolloConfig
@EnableFeignClients(basePackages = "{{package}}.feign")
@EnableAspectJAutoProxy
public class ScaffoldApp {
    public static void main(String[] args) {
        SpringApplication.run(ScaffoldApp.class, args);
    }
}
