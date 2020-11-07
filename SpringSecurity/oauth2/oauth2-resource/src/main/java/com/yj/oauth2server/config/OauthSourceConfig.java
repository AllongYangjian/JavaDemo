package com.yj.oauth2server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: OauthSourceConfig
 * Author:   YJ
 * Date:     2020/11/2 13:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/2 13:20        1.0              描述
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true)
public class OauthSourceConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    //设置token持久化策略
    @Bean
    public TokenStore jdbcTokenStore() {
        return new JdbcTokenStore(dataSource);
    }


    /**
     * 指定当前资源的id和存储方式
     *
     * @param resources
     * @throws Exception
     */
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("product_api")
                .tokenStore(jdbcTokenStore());
    }

    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/**").access("#oauth2.hasScope('read')")
                .antMatchers(HttpMethod.POST,"/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.PATCH,"/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.PUT,"/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.DELETE,"/**").access("#oauth2.hasScope('write')")
                .and()
                .headers().addHeaderWriter((request, response) -> {
                response.addHeader("Access-Control-Allow-Origin","*");
                if(request.getMethod().equals("OPTIONS")){
                    response.setHeader("Access-Control-Allow-Methods",request.getHeader("Access-Control-Request-Method"));
                    response.setHeader("Access-Control-Allow-Headers",request.getHeader("Access-Control-Allow-Headers"));
                }
        });
    }
}
