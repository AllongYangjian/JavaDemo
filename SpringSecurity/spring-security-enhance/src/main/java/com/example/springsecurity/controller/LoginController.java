package com.example.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


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
@Controller
@RequestMapping("/auth/login")
public class LoginController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public String login(Map<String, Object> map, String username, String password) {
        System.err.println(username + "," + password);
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            manager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(token);
            return "success";
        } catch (Exception e) {
            map.put("error", "用户名或密码错误：" + e.getMessage());
            return "error";
        }
    }
}
