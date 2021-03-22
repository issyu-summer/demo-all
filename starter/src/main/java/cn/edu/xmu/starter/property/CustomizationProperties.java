package cn.edu.xmu.starter.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author summer
 * @date 2021/2/21 23:04
 */
@ConfigurationProperties(prefix = "spring.customization")
@Data
public class CustomizationProperties {

    private String name;
    private int age;

    private String sex="M";
}
