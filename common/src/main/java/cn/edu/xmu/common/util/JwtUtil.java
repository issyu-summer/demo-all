package cn.edu.xmu.common.util;

import cn.edu.xmu.common.model.VerifyCode;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author issyu 30320182200070
 * @date 2021/2/7 11:34
 */
@Slf4j
public class JwtUtil {

    private static long EXPIRE_TIME ;

    @Value("${JWT.expired-time}")
    public void setTokenExpireTime(Long expireTime){
        JwtUtil.EXPIRE_TIME=expireTime;
    }
    //token密钥
    private static final String SECRET="token-test";

    /**
     * 生成token
     */
    public static String generateToken(
            String userName,
            String password){
        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
        //设置算法
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        Map<String,Object> header = new HashMap<>();
        header.put("typ","JWT");
        header.put("alg","HS256");
        String token;
        token = JWT.create()
                .withHeader(header)
                .withClaim("name",userName)
                .withClaim("password",password)
                .withExpiresAt(date)
                .sign(algorithm);
        return token;
    }

    /**
     * token校验
     */
    public static VerifyCode verify(
            String token,
            String name,
            String password){
        VerifyCode verifyCode;
        try{
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWT.require(algorithm).build().verify(token);
            verifyCode=VerifyCode.VERIFY_OK;
        }catch (TokenExpiredException e){
            log.warn("token已经过期",e);
            verifyCode=VerifyCode.TOKEN_EXPIRED;
        }catch (JWTVerificationException e){
            log.warn("token校验失败",e);
            verifyCode=VerifyCode.VERIFY_FAILURE;
        }
        DecodedJWT decodedJwt = JWT.decode(token);
        String nameJwt=
                decodedJwt.getClaim("name").as(String.class);
        String passwordJwt =
                decodedJwt.getClaim("password").asString();
        if(!name.equals(nameJwt)||!password.equals(passwordJwt)){
            verifyCode=VerifyCode.NAME_PASSWORD_NOT_MATCH;
        }
        return verifyCode;
    }

    /**
     *从token中解析出user
     */
    public static User getUserFromToken(String token){
        DecodedJWT decodedJwt = JWT.decode(token);
        String nameJwt=
                decodedJwt.getClaim("name").as(String.class);
        String passwordJwt =
                decodedJwt.getClaim("password").asString();
        User user = new User(nameJwt,passwordJwt);
        return user;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class User{
        private String name;
        private String password;
    }

}
