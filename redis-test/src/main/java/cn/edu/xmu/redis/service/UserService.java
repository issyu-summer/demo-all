package cn.edu.xmu.redis.service;

import cn.edu.xmu.redis.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author issyu 30320182200070
 * @date 2021/1/14 18:36
 */
public interface UserService extends IService<User> {

    /**
     * 通过用户id查找用户
     * @param userId
     * @return
     */
    User selectUserByUserId(Long userId);

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> selectAllUser();
}
