package cn.edu.xmu.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author issyu 30320182200070
 * @date 2021/2/1 20:28
 */
@RestController
public class MainController {

    @GetMapping("/hello")
    public Object hello(){
        return "hello";
    }
}
