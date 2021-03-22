package cn.edu.xmu.mybatisplus.service;

import cn.edu.xmu.mybatisplus.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.core.entity.LoginUser;

/**
 * @author issyu 30320182200070
 * @date 2021/1/12 12:36
 */
public interface UserService extends IService<User> {

    /**
     * 根据id查找用户信息
     * @param userId
     * @param age
     * @return User
     */
    User selectUserById(Long userId,Integer age);

    /**
     * 用户登陆,未考虑密码的加密，篡改等等。。。。
     * @param loginUser
     * @return
     */
    String userLogin(LoginUser loginUser);

    /**
     * 用户等处
     * @param userId
     * @return
     */
    Boolean userLogout(Long userId);

}
