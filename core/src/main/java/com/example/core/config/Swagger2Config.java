package com.example.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author issyu 30320182200070
 * @date 2021/1/16 23:06
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    //    @Bean
//    public Docket docketTest(){
//        return new Docket(DocumentationType.SWAGGER_2);
//    }
    @Bean
    public Docket docket(Environment environment){
        //dev或者test环境
        Profiles profiles = Profiles.of("dev","test");
        //判断工程所处的环境
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                .enable(false)
//                .groupName("summer")
                .select()
                //扫描的api
                .apis(RequestHandlerSelectors.basePackage("cn.edu.xmu.mybatisplus"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("summer","none","2119635988@qq.com");
        return new ApiInfo(
                "summer-test-swagger2",
                "description",
                "version:1.0.0",
                "localhost:8080",
                contact,
                "none",
                "none",
                new ArrayList<>()
        );
    }
}
