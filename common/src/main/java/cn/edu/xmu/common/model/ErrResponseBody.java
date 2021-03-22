package cn.edu.xmu.common.model;

import lombok.Getter;

import java.io.Serializable;

/**
 * 专用于出错时的返回体
 * @author issyu 30320182200070
 * @date 2021/2/5 12:42
 */
@Getter
public class ErrResponseBody implements Serializable {

    private int code;
    private String message;

    public ErrResponseBody(ResponseCode responseCode){
        this.code=responseCode.getCode();
        this.message=responseCode.getMessage();
    }
}
