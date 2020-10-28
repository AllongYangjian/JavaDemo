package com.yj.resource.controller;

import org.springframework.security.access.annotation.Secured;
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
    @Secured("ROLE_PRODUCT")
    @RequestMapping("/findAll")
    public String findAll() {
        return "查询产品列表成功";
    }
}
