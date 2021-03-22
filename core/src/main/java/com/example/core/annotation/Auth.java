package com.example.core.annotation;

import java.lang.annotation.*;

/**
 * 权限校验
 * @author issyu 30320182200070
 * @date 2021/1/19 15:52
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface Auth {
}
