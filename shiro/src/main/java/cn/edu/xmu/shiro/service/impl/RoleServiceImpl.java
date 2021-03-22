package cn.edu.xmu.shiro.service.impl;

import cn.edu.xmu.shiro.entity.Role;
import cn.edu.xmu.shiro.mapper.RoleMapper;
import cn.edu.xmu.shiro.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author summer
 * @since 2021-02-04
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
