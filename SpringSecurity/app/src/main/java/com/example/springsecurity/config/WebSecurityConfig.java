package com.example.springsecurity.config;

import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: WebSecurityConfig
 * Author:   YJ
 * Date:     2020/9/29 14:35
 * Description: Spring Security Config
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/29 14:35        1.0              描述
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

//        http.rememberMe()
//                .rememberMeServices(rememberMeServices())
//                .key("INTERNAL_SECRET_KEY");
    }

//    @Bean
//    public RememberMeServices rememberMeServices() {
//        JdbcTokenRepositoryImpl rememberMeTokenRepository = new JdbcTokenRepositoryImpl();
//        // 此处需要设置数据源，否则无法从数据库查询验证信息
//        rememberMeTokenRepository.setDataSource(dataSource);
//
//        // 此处的 key 可以为任意非空值(null 或 "")，单必须和起前面
//        // rememberMeServices(RememberMeServices rememberMeServices).key(key)的值相同
//        PersistentTokenBasedRememberMeServices rememberMeServices =
//                new PersistentTokenBasedRememberMeServices("INTERNAL_SECRET_KEY", userDetailsService, rememberMeTokenRepository);
//
//        // 该参数不是必须的，默认值为 "remember-me", 但如果设置必须和页面复选框的 name 一致
//        rememberMeServices.setParameter("remember-me");
//        return rememberMeServices;
//    }

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
//        builder.inMemoryAuthentication()
//                .passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("user")
//                .password(new BCryptPasswordEncoder().encode("123"))
//                .roles("USER");
     builder.userDetailsService(userService)
             .passwordEncoder(passwordEncoder());
    }
}
