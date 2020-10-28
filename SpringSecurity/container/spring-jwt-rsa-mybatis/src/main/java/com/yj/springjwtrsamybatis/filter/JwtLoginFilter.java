package com.yj.springjwtrsamybatis.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yj.common.utils.JwtUtils;
import com.yj.springjwtrsamybatis.config.RsaKeyProperties;
import com.yj.springjwtrsamybatis.domain.SysRole;
import com.yj.springjwtrsamybatis.domain.SysUser;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: JwtLoginFilter
 * Author:   yangjian
 * Date:     2020/10/28 22:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/28 22:58        1.0              描述
 */
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private RsaKeyProperties rsaKeyProperties;

    public JwtLoginFilter(AuthenticationManager authenticationManager, RsaKeyProperties rsaKeyProperties) {
        this.authenticationManager = authenticationManager;
        this.rsaKeyProperties = rsaKeyProperties;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            SysUser sysUser = new ObjectMapper().readValue(request.getInputStream(), SysUser.class);
            System.err.println(sysUser.toString());
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(sysUser.getUsername(), sysUser.getPassword());
            return authenticationManager.authenticate(token);
        } catch (Exception e) {
            try {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

                Map<String, Object> map = new HashMap<>();
                map.put("code", HttpServletResponse.SC_UNAUTHORIZED);
                map.put("msg", "用户名或密码错误");
                PrintWriter writer = response.getWriter();
                writer.write(new ObjectMapper().writeValueAsString(map));

                writer.flush();
                writer.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            throw new RuntimeException();
        }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(authResult.getName());
        sysUser.setRoles((List<SysRole>) authResult.getAuthorities());
        System.err.println(sysUser.toString());
        String token = JwtUtils.generateTokenExpireInMinutes(sysUser, rsaKeyProperties.getPrivateKey(), 24 * 60);
        response.addHeader("Authorization", "Bearer " + token);
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);

            Map<String, Object> map = new HashMap<>();
            map.put("code", HttpServletResponse.SC_OK);
            map.put("msg", "认证成功");
            PrintWriter writer = response.getWriter();
            writer.write(new ObjectMapper().writeValueAsString(map));

            writer.flush();
            writer.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
