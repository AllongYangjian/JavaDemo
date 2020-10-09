package com.example.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: ProductController
 * Author:   YJ
 * Date:     2020/10/9 20:11
 * Description: 产品了Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/10/9 20:11        1.0              描述
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/findAll")
    public String findAll(){
        return "product-list";
    }
}
