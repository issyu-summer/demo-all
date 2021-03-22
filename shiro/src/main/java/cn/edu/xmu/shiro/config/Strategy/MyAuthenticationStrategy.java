package cn.edu.xmu.shiro.config.Strategy;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.AuthenticationStrategy;
import org.apache.shiro.realm.Realm;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author summer
 * @date 2021/2/15 12:41
 */
@Slf4j
@Component
public class MyAuthenticationStrategy implements AuthenticationStrategy {

    @Override
    public AuthenticationInfo beforeAllAttempts(Collection<? extends Realm> collection, AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }

    @Override
    public AuthenticationInfo beforeAttempt(Realm realm, AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) throws AuthenticationException {
        return null;
    }

    @Override
    public AuthenticationInfo afterAttempt(Realm realm, AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo, AuthenticationInfo authenticationInfo1, Throwable throwable) throws AuthenticationException {
        return null;
    }

    @Override
    public AuthenticationInfo afterAllAttempts(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) throws AuthenticationException {
        return null;
    }
}
