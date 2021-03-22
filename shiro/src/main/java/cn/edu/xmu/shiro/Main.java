package cn.edu.xmu.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author issyu 30320182200070
 * @date 2021/2/4 16:39
 */
@SpringBootApplication(scanBasePackages = {"cn.edu.xmu.shiro","cn.edu.xmu.common"})
@MapperScan("cn.edu.xmu.shiro.mapper")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
