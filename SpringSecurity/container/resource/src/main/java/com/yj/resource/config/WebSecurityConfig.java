package com.yj.resource.config;

import com.yj.resource.filter.JwtVerifyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: WebSecurityConfig
 * Author:   yangjian
 * Date:     2020/10/28 23:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/28 23:31        1.0              描述
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RsaKeyProperties prop;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/product").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .addFilter(new JwtVerifyFilter(super.authenticationManager(), prop))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
