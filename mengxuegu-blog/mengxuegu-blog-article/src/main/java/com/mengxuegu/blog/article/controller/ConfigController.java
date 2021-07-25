package com.mengxuegu.blog.article.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ConfigController
 * Author:   yangjian
 * Date:     2021/7/25 22:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/25 22:26        1.0              描述
 */
@RestController
@RequestMapping("/config")
@RefreshScope
@Api(value = "Nacos配置服务测试",description = "获取Nacos配置信息")
public class ConfigController {

    @Value("${user.name}")
    private String name;

    private String value;

    @GetMapping("/config")
    public String config(){
        return name;
    }

}
