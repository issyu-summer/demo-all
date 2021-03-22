package cn.edu.xmu.starter.config;

import cn.edu.xmu.starter.property.CustomizationProperties;
import cn.edu.xmu.starter.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author summer
 * @date 2021/2/21 23:13
 */
@Configuration
@EnableConfigurationProperties(CustomizationProperties.class)
@ConditionalOnClass(CustomService.class)
@ConditionalOnProperty(prefix = "spring.customization",value = "enable",matchIfMissing = true)
public class CustomizationAutoConfig {

    @Autowired
    private CustomizationProperties customizationProperties;

    @Bean
    public CustomService customService(){
        return new CustomService(customizationProperties);
    }

}
