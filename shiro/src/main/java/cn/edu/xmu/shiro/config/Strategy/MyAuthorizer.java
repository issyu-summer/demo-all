package cn.edu.xmu.shiro.config.Strategy;

import org.apache.shiro.authc.AbstractAuthenticator;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author summer
 * @date 2021/2/15 16:24
 */
public class MyAuthorizer extends AbstractAuthenticator {
    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
