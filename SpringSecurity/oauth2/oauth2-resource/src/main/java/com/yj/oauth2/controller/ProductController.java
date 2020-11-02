package com.yj.oauth2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: ProductController
 * Author:   YJ
 * Date:     2020/11/2 13:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/2 13:39        1.0              描述
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/findAll")
    public String findProduct() {
        return "查找产品列表成功";
    }
}
