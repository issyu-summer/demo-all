package cn.edu.xmu.common.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author issyu 30320182200070
 * @date 2021/2/5 11:42
 */
@Slf4j
@Component
public class ResponseInterceptor implements HandlerInterceptor {

    public static final String RESPONSE_ANN="response-ann";
    public static final String INCLUDE_CODE="include_code";

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        log.info("judging response body type ...");
        if(handler instanceof HandlerMethod){
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            //获取bean对象
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            //检查bean对象上的注解是不是EmbellishResponse
            if(clazz.isAnnotationPresent(EmbellishResponse.class)){
                request.setAttribute(RESPONSE_ANN,
                        clazz.getAnnotation(EmbellishResponse.class));
            }else if(method.isAnnotationPresent(EmbellishResponse.class)){
                request.setAttribute(RESPONSE_ANN,
                        method.getAnnotation(EmbellishResponse.class));
            }
            //clazz.getAnnotation(IncludeCode.class).responseCode().toString()
//            if(clazz.isAnnotationPresent(IncludeCode.class)){
//                request.setAttribute(INCLUDE_CODE,
//                        clazz.getAnnotation(IncludeCode.class));
//            }else if(method.isAnnotationPresent(IncludeCode.class)){
//                request.setAttribute(INCLUDE_CODE,
//                        method.getAnnotation(EmbellishResponse.class));
//            }
        }
        return true;
    }
}
