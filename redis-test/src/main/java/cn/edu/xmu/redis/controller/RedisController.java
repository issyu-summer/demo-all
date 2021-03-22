package cn.edu.xmu.redis.controller;

import cn.edu.xmu.redis.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author issyu 30320182200070
 * @date 2021/1/14 23:47
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public Object selectUserByUserId(
            @PathVariable("id") Long userId
    ){
        return userService.selectUserByUserId(userId);
    }
}
