package cn.edu.xmu.shiro.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author issyu 30320182200070
 * @date 2021/2/4 20:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthUserRole extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private Long roleId;
}
