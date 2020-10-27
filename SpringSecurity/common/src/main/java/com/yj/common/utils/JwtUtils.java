package com.yj.common.utils;

import com.yj.common.domain.Payload;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.UUID;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: JwtUtils
 * Author:   yangjian
 * Date:     2020/10/27 23:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/27 23:19        1.0              描述
 */
public class JwtUtils {

    private static final String JWT_PAYLOAD_USER_KEY = "user";

    /**
     * 私钥加密
     * @param useInfo 用户信息
     * @param privateKey 私钥
     * @param expire 过期时间
     * @return s
     */
    public static String generateTokenExpireInMinutes(Object useInfo, PrivateKey privateKey, int expire) {
        return Jwts.builder()
                .claim(JWT_PAYLOAD_USER_KEY, JsonUtils.toString(useInfo))
                .setId(createJTI())
                .setExpiration(DateTime.now().plusMinutes(expire).toDate())
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    /**
     * 私钥加密
     * @param useInfo 用户信息
     * @param privateKey 私钥
     * @param expire 过期时间
     * @return
     */
    public static String generateTokenExpireInSeconds(Object useInfo, PrivateKey privateKey, int expire) {
        return Jwts.builder()
                .claim(JWT_PAYLOAD_USER_KEY, JsonUtils.toString(useInfo))
                .setId(createJTI())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }

    /**
     * 解析Token
     * @param token
     * @param publicKey
     * @return
     */
    public static Jws<Claims> parseToken(String token, PublicKey publicKey) {
        return Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
    }

    /**
     * 产生一个随机ID
     * @return
     */
    public static String createJTI() {
        return new String(Base64.getEncoder().encode(UUID.randomUUID().toString().getBytes()));
    }



    /**
     * 获取Token中的用户信息
     * @param token 令牌
     * @param publicKey 公钥
     * @param userType 用户信息
     * @param <T> 类型
     * @return
     */
    public static <T> Payload<T> getInfoFromToken(String token, PublicKey publicKey, Class<T> userType) {
        Jws<Claims> claimsJws = parseToken(token, publicKey);
        Claims body = claimsJws.getBody();
        Payload<T> claims = new Payload<>();
        claims.setId(body.getId());
        claims.setUserInfo(JsonUtils.toBean(body.get(JWT_PAYLOAD_USER_KEY).toString(), userType));
        claims.setExpiration(body.getExpiration());
        return claims;
    }

    public static <T> Payload<T> geInfoFromToken(String token,PublicKey publicKey){
        Jws<Claims> claimsJws = parseToken(token, publicKey);
        Claims body = claimsJws.getBody();
        Payload<T> claims = new Payload<>();
        claims.setId(body.getId());
        claims.setExpiration(body.getExpiration());
        return claims;
    }





}
