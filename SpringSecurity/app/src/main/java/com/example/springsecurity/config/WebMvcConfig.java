package com.example.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: WebMvcConfig
 * Author:   YJ
 * Date:     2020/9/29 14:46
 * Description: Web MVC Config
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/29 14:46        1.0              描述
 */
@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/403").setViewName("403");
        registry.addViewController("/500").setViewName("500");
    }
}
