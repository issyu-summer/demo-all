package com.example.core.util;

import com.example.core.entity.LoginUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.*;

/**
 * @author issyu 30320182200070
 * @date 2021/1/19 16:22
 */
public class JwtUtil {

    public static final String LOGIN_TOKEN_KEY = "authorization";
    /**
     * HS256-密钥,不可以是公有的
     */
    private static final String secret = "SECRET";

    /**
     * 创建token
     * @param loginUser
     * @param hours
     * @return
     */
    public static String createToken(LoginUser loginUser, Integer hours) {

        //JWT头部：类型JWT,加密算法HS256

//        String header = "{\n" +
//                "\"typ\": \"JWT\",\n" +
//                "\n" +
//                "\"alg\": \"HS256\"\n" +
//                "\n" +
//                "}";

        //设置密钥
        Algorithm algorithm = Algorithm.HMAC256(secret);

        Map header = new HashMap<String,Object>();
        header.put("typ","JWT");
        header.put("alg","HS256");
        //JWT创建器
        String token = JWT.create()
                .withHeader(header)
                .withIssuer("superDemo")
                .withIssuedAt(new Date())
                .withExpiresAt(DateTimeUtil.addHours(new Date(),hours))
                .withClaim("userId",loginUser.getUserId())
                .withClaim("userName",loginUser.getName())
                .withClaim("password",loginUser.getPassword())
                .sign(algorithm);
        //使用redis保存token,放在模块内部比较合适,降低耦合
        return token;
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static LoginUser verifyToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier jwtVerifier = JWT.require(algorithm)
                .withIssuer("superDemo")
                .build();

        DecodedJWT decodedJwt = jwtVerifier.verify(token);

        Map<String, Claim> claimMaps = decodedJwt.getClaims();
        Long userId = claimMaps.get("userId").asLong();
        String userName = claimMaps.get("userName").asString();
        String password = claimMaps.get("password").asString();

        return new LoginUser(userId,userName,password);
    }
}
