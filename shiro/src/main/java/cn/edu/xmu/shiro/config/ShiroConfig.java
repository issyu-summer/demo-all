package cn.edu.xmu.shiro.config;

import cn.edu.xmu.shiro.config.Strategy.MyAuthenticationStrategy;
import cn.edu.xmu.shiro.config.Realm.UserRealm;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author issyu 30320182200070
 * @date 2021/2/4 21:28
 */
@Configuration
public class ShiroConfig {


    @Autowired
    private MyAuthenticationStrategy myAuthenticationStrategy;

    @Bean
    public StatelessSubjectFactory statelessSubjectFactory(){
        StatelessSubjectFactory statelessSubjectFactory = new StatelessSubjectFactory();
        return statelessSubjectFactory;
    }

    @Bean
    public SessionManager sessionManager() {
        TokenSessionManager tokenSessionManager = new TokenSessionManager();
        tokenSessionManager.setSessionValidationSchedulerEnabled(false);
        return tokenSessionManager;
    }


    @Bean
    @ConditionalOnMissingBean
    DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     *????????????????????????????????????
     * @return bean userRealm
     */
//    @Bean
//    public UserRealm userRealm(){
//        UserRealm realm = new UserRealm();
//        return realm;
//    }

    /**
     * ??????
     */
    @Bean
    UserRealm userRealm(){
        return new UserRealm();
    }

    /**
     *??????realm???????????????
     */
    @Bean
    SecurityManager securityManager(){
        DefaultWebSecurityManager defaultSecurityManager =
                new DefaultWebSecurityManager();
        defaultSecurityManager.setSessionManager(sessionManager());
        defaultSecurityManager.setRealm(userRealm());
        //defaultSecurityManager.setRealms()
        //??????????????????????????????realm?????????????????????
        //???????????????realm???????????????????????????????????????
        List<Realm> realms = new ArrayList<>();
        realms.add(userRealm());
        ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
        modularRealmAuthenticator.setAuthenticationStrategy(myAuthenticationStrategy);
        modularRealmAuthenticator.setRealms(realms);
        defaultSecurityManager.setAuthenticator(modularRealmAuthenticator);
        //????????????
        ModularRealmAuthorizer modularRealmAuthorizer
                = new ModularRealmAuthorizer();
        /*??????????????????????????????*/
        //modularRealmAuthorizer.setPermissionResolver();
        // ?????? ShiroDAO ??????
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        // ???????????? Shiro Session ??????????????????????????????????????? Http Session ??????
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        defaultSecurityManager.setSubjectDAO(subjectDAO);

        defaultSecurityManager.setSubjectFactory(statelessSubjectFactory());
        return defaultSecurityManager;
    }

    /**
     * Filter??????,??????????????????????????????????????????
     */
    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean
                = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("statelessFilter",new StatelessAuthFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        Map<String,String> map = new HashMap<>();
        map.put("/logout","logout");
        map.put("/**","authc");

        shiroFilterFactoryBean.setLoginUrl("/login");

        shiroFilterFactoryBean.setSuccessUrl("/index");

        shiroFilterFactoryBean.setUnauthorizedUrl("/error");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
