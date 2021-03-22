package com.example.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author issyu 30320182200070
 * @date 2021/1/19 16:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {


    private Long userId;

    private String name;

    private String password;

}
