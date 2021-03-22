package cn.edu.xmu.redis.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import java.io.Serializable;

/**
 * @author issyu 30320182200070
 * @date 2021/1/14 17:53
 */
@Data
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Integer age;
    private String email;
}
