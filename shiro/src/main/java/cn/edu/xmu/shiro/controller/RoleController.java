package cn.edu.xmu.shiro.controller;


import cn.edu.xmu.common.annotation.EmbellishResponse;
import cn.edu.xmu.shiro.entity.User;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author summer
 * @since 2021-02-04
 */
@RestController
@RequestMapping("/shiro/role")
public class RoleController {

    @GetMapping(value = "/test",produces = "application/json;charset=utf-8")
    @EmbellishResponse
    public Object test(){
        return new User("sadfas","asfdasf");
    }
}

