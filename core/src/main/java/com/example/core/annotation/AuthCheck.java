package com.example.core.annotation;

import com.example.core.entity.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.example.core.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 通过aop和注解实现权限校验
 * @author issyu 30320182200070
 * @date 2021/1/19 15:54
 */
@Slf4j
@Component
@Aspect
public class AuthCheck {

    /**
     * 权限校验的注解
     */
    @Pointcut("@annotation(com.example.core.annotation.Auth)")
    public void pointcut(){

    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Around("pointcut()")
    public Object authCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        log.info("auth checking ...");
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =
                ((ServletRequestAttributes)requestAttributes).getRequest();
        HttpServletResponse response =
                ((ServletRequestAttributes)requestAttributes).getResponse();

        String token =request.getHeader(JwtUtil.LOGIN_TOKEN_KEY);
        if(token == null){
            return "token为空";
        }
        LoginUser loginUser = JwtUtil.verifyToken(token);

        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        String key ="userId"+loginUser.getUserId();
        if(redisTemplate.hasKey(key)){
            if(valueOperations.get(key).equals(token)){
                return proceedingJoinPoint.proceed();
            }else {
                return "JWT不合法";
            }
        }else{
            return "JWT不合法";
        }

        //权限校验参考ooad,url上有路径是否具有通用性？？？
        //return proceedingJoinPoint.proceed();
    }
}
