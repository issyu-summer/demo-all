package cn.edu.xmu.mybatisplus.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author issyu 30320182200070
 * @date 2021/1/16 23:51
 */
@Api(value = "测试", tags = "test")
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
