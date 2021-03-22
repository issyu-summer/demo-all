package cn.edu.xmu.shiro.config;

import cn.edu.xmu.common.util.JwtUtil;
import cn.edu.xmu.shiro.entity.User;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.BearerToken;
import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.realm.Realm;

/**
 * @author summer
 * @date 2021/2/12 3:31
 */
public class StatelessToken extends BearerToken {

    private String userName;
    private String password;
    private String host;

    @Override
    public Object getPrincipal() {
        return userName;
    }

    @Override
    public Object getCredentials() {
        return password;
    }

    public StatelessToken(User user){
        super(JwtUtil.generateToken(user.getName(),user.getPassword()));
        this.userName=user.getName();
        this.password=user.getPassword();
    }

    public StatelessToken(JwtUtil.User user){
        super(JwtUtil.generateToken(user.getName(),user.getPassword()));
        this.userName=user.getName();
        this.password=user.getPassword();
    }

    @Override
    public String getHost() {
        return host;
    }

    /**
     * 通过token解析出user
     */
    public User verify(){
        JwtUtil.User user = JwtUtil.getUserFromToken(this.getToken());
        return new User(user.getName(),user.getPassword());
    }
}
