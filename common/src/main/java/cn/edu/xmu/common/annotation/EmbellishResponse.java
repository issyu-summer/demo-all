package cn.edu.xmu.common.annotation;

import cn.edu.xmu.common.model.ResponseCode;
import org.springframework.http.HttpStatus;

import java.lang.annotation.*;

/**
 * @author issyu 30320182200070
 * @date 2021/2/5 11:52
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface EmbellishResponse {
    /**
     * 通过注解指定状态码类型，默认位OK
     * @return 状态码
     */
    ResponseCode responseCode() default ResponseCode.OK;

    /**
     * http状态码适用于错误处理？何种错误处理。内部的机制是将错误处理和正确的结果给分开了
     * 通过注解指定http状态ma
     */
    //HttpStatus httpStatus() default HttpStatus.OK;
}
