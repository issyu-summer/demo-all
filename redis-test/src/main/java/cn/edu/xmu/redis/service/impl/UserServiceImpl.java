package cn.edu.xmu.redis.service.impl;

import cn.edu.xmu.redis.mapper.UserMapper;
import cn.edu.xmu.redis.model.User;
import cn.edu.xmu.redis.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author issyu 30320182200070
 * @date 2021/1/14 18:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public User selectUserByUserId(Long userId) {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(User::getId,userId);
        String key ="user_id"+userId;
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            User user = operations.get(key);
            return user;
        }else{
            User user = this.getById(userId);
            operations.set(key,user,5, TimeUnit.HOURS);
            return this.getById(userId);
        }
    }

    @Override
    public List<User> selectAllUser() {
        return null;
    }
}
