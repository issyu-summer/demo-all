package cn.edu.xmu.shiro.entity;

import cn.edu.xmu.common.annotation.IncludeCode;
import cn.edu.xmu.common.model.ResponseCode;
import cn.edu.xmu.shiro.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class User extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  private String name;

  /**
   * 加密
   */
  private String password;

  /**
   * 角色合集
   */
  private Long roleId;

    public User(String name, String password) {
        this.name=name;
        this.password=password;
    }
}
