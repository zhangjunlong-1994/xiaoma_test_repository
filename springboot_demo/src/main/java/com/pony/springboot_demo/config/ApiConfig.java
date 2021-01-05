package com.pony.springboot_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zjl
 * @date 2020/10/17 10:04
 * swagger配置类
 */
@Configuration
@EnableSwagger2
public class ApiConfig {

    /**
     * 生成swagger Api接口文档
     * @return
     */
    @Bean
    public Docket docket( ){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pony"))
                .build()
                .apiInfo(apiInfo());
    }

    /**
     * swagger接口文档说明信息
     * @return wagger接口文档说明信息
     */
    public ApiInfo apiInfo( ){
        return new ApiInfoBuilder()
                .title("小马科技接口API说明文档")
                .version("1.0.0")
                .description("springboot_demo接口API说明文档")
                .contact(new Contact("ZhangJunLong", "http://www.pony.com", "18145694229@139.com"))
                .license("")
                .licenseUrl("")
                .build();
    }
}
