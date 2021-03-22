package cn.edu.xmu.common.model;

/**
 * @author issyu 30320182200070
 * @date 2021/2/7 11:56
 */
public enum VerifyCode {

    VERIFY_OK(501,"jwt校验通过"),
    VERIFY_FAILURE(502,"jwt校验失败"),
    TOKEN_EXPIRED(503,"jwt已过期"),
    NAME_PASSWORD_NOT_MATCH(504,"用户名或密码错误");
    private int code;
    private String message;

    VerifyCode(int i, String s) {
        this.code = i;
        this.message=s;
    }
    public String getMessage(){
        return this.message;
    }
    public int getCode(){
        return  this.code;
    }
}
