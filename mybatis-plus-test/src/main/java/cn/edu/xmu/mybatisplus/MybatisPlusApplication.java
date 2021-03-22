package cn.edu.xmu.mybatisplus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.propertyeditors.ClassArrayEditor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author issyu 30320182200070
 * @date 2021/1/12 12:18
 */
@SpringBootApplication(scanBasePackages = {"cn.edu.xmu.mybatisplus","com.example.core"})
@MapperScan("cn.edu.xmu.mybatisplus.mapper")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

}



