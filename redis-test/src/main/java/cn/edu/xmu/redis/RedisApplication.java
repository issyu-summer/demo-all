package cn.edu.xmu.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author issyu 30320182200070
 * @date 2021/1/14 17:54
 */
@SpringBootApplication
@MapperScan("cn.edu.xmu.redis.mapper")
public class RedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

}
