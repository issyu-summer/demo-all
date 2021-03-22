package cn.edu.xmu.shiro.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.apache.shiro.web.subject.WebSubject;
import org.apache.shiro.web.subject.WebSubjectContext;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author summer
 * @date 2021/2/11 22:36
 */
@Slf4j
public class StatelessSubjectFactory extends DefaultWebSubjectFactory {

    private static final String TOKEN = "Authorization";

    private static final String TOKEN_CHECK="token-check";

    @Override
    public Subject createSubject(SubjectContext context) {
        String token;
        boolean isNotBasedOnWebSubject = context.getSubject() != null && !(context.getSubject() instanceof WebSubject);
        if (context instanceof WebSubjectContext && !isNotBasedOnWebSubject) {
            WebSubjectContext wsc = (WebSubjectContext)context;
            ServletRequest request = wsc.resolveServletRequest();
            ServletResponse response = wsc.resolveServletResponse();
            token=WebUtils.toHttp(request).getHeader(TOKEN);
            if(!StringUtils.isNotEmpty(token)){
                log.info("token:"+token);
                //token检测通过
                request.setAttribute(TOKEN_CHECK, Boolean.TRUE);
            }else {
                log.info("token is empty");
                request.setAttribute(TOKEN_CHECK,Boolean.FALSE);
            }
        }
        //不创建session
        context.setSessionCreationEnabled(false);
        return super.createSubject(context);
    }
}
