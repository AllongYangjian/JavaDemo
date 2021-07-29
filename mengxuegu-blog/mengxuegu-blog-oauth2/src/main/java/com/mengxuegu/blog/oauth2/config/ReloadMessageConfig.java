package com.mengxuegu.blog.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ReloadMessageConfig
 * Author:   yangjian
 * Date:     2021/7/30 0:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/30 0:11        1.0              描述
 */
@Configuration
public class ReloadMessageConfig {
    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        resourceBundleMessageSource.setBasename("classpath:messages_zh_CN");
        return resourceBundleMessageSource;
    }
}
