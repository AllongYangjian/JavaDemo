package com.example.springsecurityjwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: MyWebMvcConfigurator
 * Author:   YJ
 * Date:     2020/11/27 11:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/27 11:21        1.0              描述
 */
@Configuration
public class MyWebMvcConfigurator implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/error").setViewName("error");
//        registry.addViewController("/success").setViewName("success");
    }
}
