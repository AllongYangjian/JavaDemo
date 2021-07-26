package com.mengxuegu.blog.question.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: MybatisPlusConfig
 * Author:   yangjian
 * Date:     2021/7/19 23:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/19 23:00        1.0              描述
 */
@Configuration
@MapperScan("com.mengxuegu.blog.question.mapper")
@EnableTransactionManagement
public class MybatisPlusConfig {

    /**
     *分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
