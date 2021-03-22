package cn.edu.xmu.shiro.entity.vo;

import cn.edu.xmu.common.util.JwtUtil;
import cn.edu.xmu.shiro.entity.User;
import lombok.Data;

/**
 * @author issyu 30320182200070
 * @date 2021/2/6 12:48
 */
@Data
public class UserVo {

    private Long userId;
    private String token;

    public UserVo(Long userId,User user){
        this.userId=userId;
        this.token= JwtUtil.generateToken(user.getName(),user.getPassword());
    }
}
