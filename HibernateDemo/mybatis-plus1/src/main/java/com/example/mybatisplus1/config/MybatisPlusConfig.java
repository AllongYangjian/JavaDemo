package com.example.mybatisplus1.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.IllegalSQLInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: MybatisPlusConfig
 * Author:   yangjian
 * Date:     2020/12/6 22:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/12/6 22:28        1.0              描述
 */
@Configuration
@MapperScan("com.example.mybatisplus1.mapper")
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        interceptor.addInnerInterceptor(illegalSQLInnerInterceptor());
        return interceptor;
    }

    @Bean
    public IllegalSQLInnerInterceptor illegalSQLInnerInterceptor(){
        IllegalSQLInnerInterceptor interceptor = new IllegalSQLInnerInterceptor();
        return interceptor;
    }
}
