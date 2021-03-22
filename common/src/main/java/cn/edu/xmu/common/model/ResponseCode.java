package cn.edu.xmu.common.model;

import lombok.Data;

/**
 * @author issyu 30320182200070
 * @date 2021/2/5 12:26
 */

public enum ResponseCode {

    OK(0,"成功"),
    CREATE(401,"成功"),
    TOKEN_EMPTY(402,"token为空"),
    FAILURE(999,"失败");
    private int code;
    private String message;

    ResponseCode(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }

}
