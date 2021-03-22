package cn.edu.xmu.shiro.config;

import cn.edu.xmu.common.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author summer
 * @date 2021/2/12 3:22
 */
@Slf4j
public class StatelessAuthFilter extends AccessControlFilter {

    private static final String TOKEN = "Authorization";

    private static final String TOKEN_CHECK="token-check";

    @Override
    protected boolean isAccessAllowed(
            ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(
            ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token= WebUtils.toHttp(servletRequest).getHeader(TOKEN);
        if(StringUtils.isNotEmpty(token)){
            log.info("token:"+token);
            servletRequest.setAttribute(TOKEN_CHECK,Boolean.TRUE);
        }else {
            log.error("token is empty");
            servletRequest.setAttribute(TOKEN_CHECK,Boolean.FALSE);
        }
        StatelessToken authToken = new StatelessToken(JwtUtil.getUserFromToken(token));
        try{
            getSubject(servletRequest,servletResponse).login(authToken);
        }catch (Exception e){
            onLoginFail(servletResponse);
            return false;
        }
        return true;
    }

    /**
     * 登陆失败返回错误401
     */
    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpServletResponse =
                (HttpServletResponse) response;
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.getWriter().write("login error");
    }
}
