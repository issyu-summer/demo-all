package cn.edu.xmu.shiro.entity;

import cn.edu.xmu.shiro.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author summer
 * @since 2021-02-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;
}
