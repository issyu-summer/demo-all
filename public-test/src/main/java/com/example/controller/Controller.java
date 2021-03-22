package com.example.controller;

import cn.edu.xmu.starter.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author summer
 * @date 2021/2/21 23:30
 */
@RestController
@RequestMapping
public class Controller {

    @Resource
    private CustomService customService;

    @GetMapping("/starter")
    public Object starter(){
        customService.sayHello();
        return "ok";
    }


}
