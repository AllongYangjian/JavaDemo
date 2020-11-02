package com.yj.springjwtrsamybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: ProductController
 * Author:   yangjian
 * Date:     2020/10/28 22:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/28 22:53        1.0              描述
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/findAll")
    public String findAll() {
        AuthenticationManager object = authenticationManagerBuilder.getObject();
        return "查询产品列表成功";
    }

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;
}
