package cn.edu.xmu.shiro.service;

import cn.edu.xmu.shiro.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author summer
 * @since 2021-02-04
 */
public interface IUserService extends IService<User> {

    /**
     * 登陆
     * @param userName 用户名
     * @return user entity
     */
    User getUserByName(String userName);

    /**
     * 测试
     * @param userName
     * @return
     */
    User adminTest(String userName);

    /**
     * 创建用户
     * @param user name,password
     * @return msg
     */
    Object createUser(User user);
}
