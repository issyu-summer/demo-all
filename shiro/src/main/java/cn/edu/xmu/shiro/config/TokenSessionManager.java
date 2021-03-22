package cn.edu.xmu.shiro.config;

import cn.edu.xmu.common.model.ErrResponseBody;
import cn.edu.xmu.common.model.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.swing.text.StyledEditorKit;
import java.io.Serializable;

/**
 * @author issyu 30320182200070
 * @date 2021/2/5 17:01
 */
@Slf4j
public class TokenSessionManager extends DefaultWebSessionManager {
    private static final String TOKEN = "Authorization";

    private static final String TOKEN_CHECK="token-check";

    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

    public TokenSessionManager() {
        super();
        this.setSessionValidationSchedulerEnabled(false);
    }

//    @Override
//    public Serializable getSessionId(ServletRequest request, ServletResponse response) {
//        String token = WebUtils.toHttp(request).getHeader(TOKEN);
//        // 前端请求头必须传入token的值,把他的值当做是sessionId
//        if (!StringUtils.isEmpty(token)) {
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, token);
//            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
//            log.info("token:"+token);
//            //token检测通过
//            request.setAttribute(TOKEN_CHECK, Boolean.TRUE);
//            return token;
//        } else {
//            log.error("token为空");
//            // 否则按默认规则从cookie取sessionId
//            //return new ErrResponseBody(ResponseCode.CREATE);
//            //token未通过
//            request.setAttribute(TOKEN_CHECK,Boolean.FALSE);
//            return super.getSessionId(request, response);
//        }
//    }

}
