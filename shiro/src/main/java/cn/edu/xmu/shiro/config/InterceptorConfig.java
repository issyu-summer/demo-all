package cn.edu.xmu.shiro.config;

import cn.edu.xmu.common.annotation.ResponseInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author issyu 30320182200070
 * @date 2021/2/5 13:23
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private ResponseInterceptor responseInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(responseInterceptor);
    }
}
