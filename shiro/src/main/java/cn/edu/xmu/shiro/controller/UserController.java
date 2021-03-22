package cn.edu.xmu.shiro.controller;


import cn.edu.xmu.common.annotation.EmbellishResponse;
import cn.edu.xmu.common.annotation.IncludeCode;
import cn.edu.xmu.common.model.ErrResponseBody;
import cn.edu.xmu.common.model.ResponseCode;
import cn.edu.xmu.shiro.config.StatelessToken;
import cn.edu.xmu.shiro.entity.User;
import cn.edu.xmu.shiro.entity.vo.UserVo;
import cn.edu.xmu.shiro.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;


/**
 * <p>
 *  前端控制器
 * </p>
 * ("/shiro/user")
 * @author summer
 * @since 2021-02-04
 */
@RestController
@RequestMapping(produces = "application/json;charset=utf-8")
@Slf4j
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 是否会自动识别
     * @param user userInfo
     * @return msg
     */
    @PostMapping("/create/user")
    @EmbellishResponse(responseCode = ResponseCode.CREATE)
    public Object createUser(@RequestBody User user){
        if(user==null){
            return new ErrResponseBody(ResponseCode.FAILURE);
        }else {
            Object msg=iUserService.createUser(user);
            return msg;
        }
    }

    @PostMapping(value = "/login",produces = "application/json")
    @EmbellishResponse(responseCode = ResponseCode.OK)
    public Object login(@RequestBody  User user){
        if(StringUtil.isNullOrEmpty(user.getName())
                ||StringUtil.isNullOrEmpty(user.getPassword())){
            return new ErrResponseBody(ResponseCode.CREATE);
        }
        //if(XXX)  启用无状态
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getName(),user.getPassword()
        );
        //StatelessToken statelessToken = new StatelessToken(user);
        Long userId;
        try{
            subject.login(usernamePasswordToken);
            //subject.login(statelessToken);
        }catch (UnknownAccountException e){
            log.error("用户名不存在-userName:"+user.getName(),e);
        }catch (AuthenticationException e){
            log.error("账号或密码错误-userName"+user.getName()
                    +"-password:"+user.getPassword(),e);
        }catch (AuthorizationException e){
            log.error("用户没有权限",e);
        }finally {
            User user1=iUserService.getUserByName(user.getName());
            userId=user1.getId();
        }
        return new UserVo(userId,user);
    }

    @RequiresRoles("admin")
    @GetMapping(value = "/admin")
    @EmbellishResponse
    public Integer admin() {
        return 1;
    }

    @RequiresPermissions("query")
    @GetMapping(value = "/index",produces = "application/json;charset=utf-8")
    @EmbellishResponse
    public Object index() {
        return new ErrResponseBody(ResponseCode.FAILURE);
    }
}

