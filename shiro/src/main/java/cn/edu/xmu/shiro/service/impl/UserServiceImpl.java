package cn.edu.xmu.shiro.service.impl;

import cn.edu.xmu.common.annotation.IncludeCode;
import cn.edu.xmu.common.model.ResponseCode;
import cn.edu.xmu.shiro.entity.User;
import cn.edu.xmu.shiro.mapper.AuthorityMapper;
import cn.edu.xmu.shiro.mapper.PermissionsMapper;
import cn.edu.xmu.shiro.mapper.RoleMapper;
import cn.edu.xmu.shiro.mapper.UserMapper;
import cn.edu.xmu.shiro.service.IAuthorityService;
import cn.edu.xmu.shiro.service.IPermissionsService;
import cn.edu.xmu.shiro.service.IRoleService;
import cn.edu.xmu.shiro.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User getUserByName(String userName) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(userName!=null){
            queryWrapper.eq("name",userName);
        }
        User user = this.getOne(queryWrapper);
        if(user!=null){

        }
        return user;
    }

    @Override
    @IncludeCode(responseCode = ResponseCode.CREATE)
    public User adminTest(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(userName!=null){
            queryWrapper.eq("name",userName);
        }
        User user = this.getOne(queryWrapper);
        return user;
    }

    /**
     * 最好用枚举
     * @param user 用户信息，来自前端
     * @return  msg
     */
    @Override
    public Object createUser(User user) {
        int count = this.getBaseMapper().insert(user);
        if(count==1){
            return "创建用户成功";
        }else {
            return "创建用户失败";
        }
    }
}
