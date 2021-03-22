package cn.edu.xmu.shiro.config.Realm;

import cn.edu.xmu.shiro.config.StatelessToken;
import cn.edu.xmu.shiro.entity.AuthRolePermissions;
import cn.edu.xmu.shiro.entity.Role;
import cn.edu.xmu.shiro.entity.User;
import cn.edu.xmu.shiro.service.IAuthorityService;
import cn.edu.xmu.shiro.service.IPermissionsService;
import cn.edu.xmu.shiro.service.IRoleService;
import cn.edu.xmu.shiro.service.IUserService;
import com.auth0.jwt.JWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author issyu 30320182200070
 * @date 2021/2/4 20:03
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    private final static String REALM_NAME ="SIMPLE-USER-NAME";

    @Autowired
    private IUserService iUserService;

    @Autowired

    private IRoleService iRoleService;

    @Autowired
    private IPermissionsService iPermissionsService;

    @Autowired
    private IAuthorityService iAuthorityService;

    @Override
    public String getName(){
        return REALM_NAME ;
    }
    /**
     * 权限（校权）配置类
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principalCollection) {
        String name = (String) principalCollection.getPrimaryPrincipal();

        User user = iUserService.getUserByName(name);
        if(user==null){
            //return
        }
        assert user != null;
        Role role = iRoleService.getById(user.getRoleId());
        if(role==null){
            //return Err
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo =
                new SimpleAuthorizationInfo();
        //添加角色
        assert role != null;
        simpleAuthorizationInfo.addRole(role.getName());
        //添加权限
        QueryWrapper<AuthRolePermissions> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",role.getId());
        List<AuthRolePermissions> list = iAuthorityService.list(queryWrapper);
        if(list.isEmpty()){
            //return Err
        }
        List<Long> ids =list.stream().
                map(AuthRolePermissions::getPermissionsId).collect(Collectors.toList());
        if(ids.isEmpty()){
            //return Err
        }
        ids.forEach(id->{
            simpleAuthorizationInfo.addStringPermission(
                    iPermissionsService.getById(id).getName());
        });
        return simpleAuthorizationInfo;
    }

    /**
     * 认证(登陆)配置类
     * @param authenticationToken 来自于用户输入
     * controller层中的usernamePasswordToken
     * 与数据库比对，如果成功则返回一个AuthenticationInfo失败则抛出异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        if(StringUtil.isNullOrEmpty((String) authenticationToken.getPrincipal())){
            log.error("principal is empty");
        }
        String name;
        /*一般来说，UsernamePasswordToken中的信息足够用了*/
        /*需要使用无状态则使用BearerToken*/
        if(authenticationToken instanceof UsernamePasswordToken){
            name=((UsernamePasswordToken) authenticationToken).getUsername();
            /*getPrincipal（）{this.getUserName()};*/
            log.info("UsernamePasswordToken类型的token");
        }else if(authenticationToken instanceof StatelessToken){
            name= String.valueOf(authenticationToken.getPrincipal());
        }else {
            name = authenticationToken.getPrincipal().toString();
            log.info(authenticationToken.getClass().getName()+"类型的token");
        }
        //获取数据库中的user,注意到数据库中的密码需要使用base64进行加密
        User user = iUserService.getUserByName(name);
        if(user==null){
            throw new UnknownAccountException("未知的用户");
        }else{
            //shiro的解码是在哪一步？
            String passwordDecode= Base64.decodeToString(user.getPassword());
            return new SimpleAuthenticationInfo(name,passwordDecode,getName());
        }
    }
}
