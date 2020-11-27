package com.example.springsecurityjwt.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springsecurityjwt.domain.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.util.Base64Utils;

import java.security.Key;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: JwtUtils
 * Author:   YJ
 * Date:     2020/11/27 15:20
 * Description: jwt 工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/27 15:20        1.0              描述
 */
public class JwtUtils {

    static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private static final String KEY = "USER_KEY";

    /**
     * Both 'payload' and 'claims' cannot both be specified. Choose either one.
     * payload 和  claims 不能同时指定
     *
     * @param object
     * @return
     */
    public static String generatorToken(Object object) {
        return Jwts.builder()
                .claim(KEY, JSON.toJSONString(object))
                .signWith(key)
                .compact();
    }

    public static SysUser decodeToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(key).parseClaimsJws(token);

        Claims body = claimsJws.getBody();
        System.err.println(body.get(KEY).toString());
        return JSON.parseObject(body.get(KEY).toString(), SysUser.class);
    }

    public static void main(String[] args) {

    }
}
