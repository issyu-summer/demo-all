package cn.edu.xmu.common.annotation;

import cn.edu.xmu.common.model.ErrResponseBody;
import cn.edu.xmu.common.model.ResponseBody;
import cn.edu.xmu.common.model.ResponseCode;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author issyu 30320182200070
 * @date 2021/2/5 12:13
 */
@Slf4j
@RestControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    public static final String RESPONSE_ANN="response-ann";

    private static final String TOKEN_CHECK="token-check";
    //public static final String INCLUDE_CODE="include-code";
    /**
     * 检测@EmbellishResponse注解
     */
    @Override
    public boolean supports(
            MethodParameter returnType,
            Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        try{
            HttpServletRequest httpRequest =
                    Objects.requireNonNull(servletRequestAttributes).getRequest();
            EmbellishResponse embellishResponse =
                    (EmbellishResponse) httpRequest.getAttribute(RESPONSE_ANN);
            //ResponseCode responseCode = embellishResponse.responseCode();
            //将状态码放进attributes\事实上没有必要
            //代码:httpRequest
            // .setAttribute(INCLUDE_CODE,responseCode);
            //代码

            return embellishResponse!=null;
        }catch (NullPointerException e){
            log.error(e.getMessage());
        }
        return false;
    }

    /**
     * 修饰返回体
     */
    @Override
    public Object beforeBodyWrite(
            Object body,
            MethodParameter returnType,
            MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType,
            ServerHttpRequest request, ServerHttpResponse response) {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpRequest =
                Objects.requireNonNull(servletRequestAttributes).getRequest();
        //token校验
        Boolean tokenCheck = (Boolean) httpRequest.getAttribute(TOKEN_CHECK);
        //String url = httpRequest.getAttribute()
        String url = httpRequest.getRequestURI();
        boolean loginUrl =false;
        /*登陆的url不需要token*/
        if("/login".equalsIgnoreCase(url)){
            loginUrl  = true;
        }
        log.info("url:"+url);
        /*通不过则返回token为空的错误码*/
        if(!loginUrl&&!tokenCheck){
            return new ErrResponseBody(ResponseCode.TOKEN_EMPTY);
        }
        //token校验
        log.info("embellish response body ...");
        //错误校验
        if(body instanceof ErrResponseBody){
            return body;
        }
        //错误校验

        //获取request中的注解中的内容
        EmbellishResponse embellishResponse =
                (EmbellishResponse) httpRequest.getAttribute(RESPONSE_ANN);
        ResponseCode responseCode = embellishResponse.responseCode();
        //获取request中的注解中的内容

        /*String需要单独重构,否则会抛出异常。使用该方法处理异常，其他的类型都可以处理*/
        if(body instanceof String){
            ResponseBody responseBody = ResponseBody.success(responseCode,body);
            ObjectMapper objectMapper = new ObjectMapper();
            String json=null;
            try {
                json = objectMapper.writeValueAsString(responseBody);
            } catch (JsonProcessingException e) {
                log.error("converter failure",e);
            }
            return json;
        }
        //没错误返回成功
        return ResponseBody.success(responseCode,body);
    }
}
