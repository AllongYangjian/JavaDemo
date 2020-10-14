package com.yj.springsecuritydemo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: ProductController
 * Author:   yangjian
 * Date:     2020/10/13 23:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/13 23:00        1.0              描述
 */
@RestController
@RequestMapping("/product")
public class ProductController {
        //需要在配置类上添加注解EnableGlobalMethodSecurity
//    @Secured("ROLE_ADMIN")
//    @RolesAllowed("ROLE_ADMIN")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @RequestMapping("/findAll")
    public String findAll() {
        return "success";
    }
}
