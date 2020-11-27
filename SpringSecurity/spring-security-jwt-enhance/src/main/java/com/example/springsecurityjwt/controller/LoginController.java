package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.domain.SysRole;
import com.example.springsecurityjwt.domain.SysUser;
import com.example.springsecurityjwt.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: LoginController
 * Author:   YJ
 * Date:     2020/11/27 13:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/27 13:14        1.0              描述
 */
@RestController
@RequestMapping("/auth/login")
public class LoginController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity<Object> login(String username, String password) {
        System.err.println(username + "," + password);
        Map<String, Object> map = new HashMap<>();
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authenticate = manager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            System.err.println(authenticate.toString());
            SysUser sysUser = new SysUser();
            sysUser.setUsername(username);
            sysUser.setRoles((List<SysRole>) authenticate.getAuthorities());

            //返回客户端调用的token
            String t = JwtUtils.generatorToken(sysUser);
            map.put("code", 200);
            map.put("status", "登录成功");
            map.put("token", "Bearer "+t);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 400);
            map.put("status", "登录失败");
            map.put("token", "");
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
