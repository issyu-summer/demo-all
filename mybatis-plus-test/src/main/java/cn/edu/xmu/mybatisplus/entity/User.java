package cn.edu.xmu.mybatisplus.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author issyu 30320182200070
 * @date 2021/1/12 12:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @ApiModelProperty(value = "用户id")
    private Long id;
    @ApiModelProperty(value = "用户名称")
    private String name;
    @ApiModelProperty(value = "用户年龄")
    private Integer age;
    @ApiModelProperty(value = "用户邮箱")
    private String email;
    @ApiModelProperty(value = "用户密码",hidden = true)
    private String password;

    public User(Long id, String name,Integer age,String email){
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setAge(age);
    }

}
