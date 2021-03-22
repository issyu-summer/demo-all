package cn.edu.xmu.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author issyu 30320182200070
 * @date 2021/2/5 12:23
 */
@Getter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ResponseBody implements Serializable {

    private int code = 0;
    private String message = null;

    private Object data;

    private ResponseBody(ResponseCode responseCode,Object data){
        this.code=responseCode.getCode();
        this.message=responseCode.getMessage();
        this.data=data;
    }

    private ResponseBody(ResponseCode responseCode){
        this.code =responseCode.getCode();
        this.message=responseCode.getMessage();
    }

    /**
     * @param data 数据
     * @return 含状态码和数据
     */
    public static ResponseBody success(Object data){
        return new ResponseBody(ResponseCode.OK,data);
    }

    /**
     * @param responseCode 其他状态码
     * @param data 数据
     * @return 含状态码和数据
     */
    public static ResponseBody success(ResponseCode responseCode,Object data){
        return new ResponseBody(responseCode,data);
    }
//    /**
//     * @param responseCode 错误码
//     * @return 仅包含错误码不含数据
//     */
//    public ResponseBody failure(ResponseCode responseCode){
//        return new ResponseBody(responseCode);
//    }
}
