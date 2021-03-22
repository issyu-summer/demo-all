package cn.edu.xmu.mybatisplus.controller;

import com.example.core.annotation.Auth;
import cn.edu.xmu.mybatisplus.entity.User;
import cn.edu.xmu.mybatisplus.service.UserService;
import com.example.core.entity.LoginUser;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author issyu 30320182200070
 * @date 2021/1/12 12:47
 */
@Api(value = "用户服务", tags = "user")
@RestController
@RequestMapping(value = "/user", produces = "application/json;charset=UTF-8")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登陆")
    @PostMapping("/login")
    @Auth
    public String userLogin(@RequestBody LoginUser loginUser){
        return userService.userLogin(loginUser);
    }

    @ApiOperation("用户登出")
    @PostMapping("/logout")
    @Auth
    public Boolean userLogout(Long userId){
        return userService.userLogout(userId);
    }

    @ApiOperation(value = "根据用户id查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户ID",dataType = "long",required = true,paramType = "path")
    })
    @ApiResponses({
            @ApiResponse(code = 0,message = "成功")
    })
    @GetMapping("/user/{id}/{age}")

    public User selectUserById(@PathVariable("id") Long userId,
                               @PathVariable("age") Integer age){
        return userService.selectUserById(userId,age);
    }
    //query参数@RequestParam(required = false)


    @PostMapping("/user")
    public User createUser(){
        return new User(4L,"user_4",26,"4-216@qq.con");
    }
}
