package {{package}}.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description: 【示例】API定义信息配置(Docket可定义多个)
 * @author: ${USER}
 * @date: Created in 10/27/21 8:01 PM
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 用户管理
     *
     * @return
     */
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("{{package}}"))
                .paths(PathSelectors.any())
                .build()
                .groupName("示例项目-用户管理");
        //.pathMapping("/manage/user");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Demo Service API")
                .version("3.0")
                .description("示例项目-API接口管理")
                .version("1.0.0")
                .build();
    }
}
