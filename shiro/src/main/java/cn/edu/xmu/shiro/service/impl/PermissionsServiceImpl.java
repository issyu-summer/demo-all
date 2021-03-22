package cn.edu.xmu.shiro.service.impl;

import cn.edu.xmu.shiro.entity.Permissions;
import cn.edu.xmu.shiro.mapper.PermissionsMapper;
import cn.edu.xmu.shiro.service.IPermissionsService;
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
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions> implements IPermissionsService {

}
