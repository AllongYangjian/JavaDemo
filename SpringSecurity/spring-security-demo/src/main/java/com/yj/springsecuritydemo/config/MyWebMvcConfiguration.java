package com.yj.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: MyWebMvcConfiguration
 * Author:   yangjian
 * Date:     2020/10/12 22:28
 * Description: 自定义WebMvc配置
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/12 22:28        1.0              描述
 */
@Configuration
public class MyWebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("/hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/test").setViewName("test");
        registry.addViewController("/403").setViewName("403");
        registry.addViewController("/500").setViewName("500");
    }
}
