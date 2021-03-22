package cn.edu.xmu.common.annotation;

import cn.edu.xmu.common.model.ResponseCode;

import java.lang.annotation.*;

/**
 * @author issyu 30320182200070
 * @date 2021/2/5 12:52
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface IncludeCode {
    /**
     * 通过注解指定状态码类型，默认位OK
     * @return 状态码
     */
    ResponseCode responseCode() default ResponseCode.OK;
}
