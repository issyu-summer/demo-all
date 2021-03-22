package cn.edu.xmu.shiro.service.impl;

import cn.edu.xmu.shiro.entity.AuthRolePermissions;
import cn.edu.xmu.shiro.mapper.AuthorityMapper;
import cn.edu.xmu.shiro.service.IAuthorityService;
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
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, AuthRolePermissions> implements IAuthorityService {

}
