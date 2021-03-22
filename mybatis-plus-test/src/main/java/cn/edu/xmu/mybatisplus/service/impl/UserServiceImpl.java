package cn.edu.xmu.mybatisplus.service.impl;

import cn.edu.xmu.mybatisplus.entity.User;
import cn.edu.xmu.mybatisplus.mapper.UserMapper;
import cn.edu.xmu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.core.entity.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import com.example.core.util.JwtUtil;

import java.util.concurrent.TimeUnit;

/**
 * @author issyu 30320182200070
 * @date 2021/1/12 12:40
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Override
    public User selectUserById(Long userId,Integer age) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",userId).eq("age",age);
        User user = this.getOne(queryWrapper);
        return user;
    }

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 默认过期时间
     */
    private static final Integer expHours = 2;

    @Override
    public String userLogin(LoginUser loginUser) {
        String userName =loginUser.getName();
        String password =loginUser.getPassword();

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",userName);
        User user = this.getOne(queryWrapper);
        if(!user.getPassword().equals(password)){
            return "login failure";
        }else{
            loginUser.setUserId(user.getId());
            String key = "userId"+user.getId();
            ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
            String token = JwtUtil.createToken(loginUser,expHours);
            //在redis中的过期时间和token的过期时间一致
            valueOperations.set(key,token,expHours, TimeUnit.HOURS);
            return token;
        }
    }

    @Override
    public Boolean userLogout(Long userId) {
        redisTemplate.delete("userId"+userId);
        return true;
    }
}
