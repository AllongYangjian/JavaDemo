package com.example.springsecurity.config;

import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: SecurityConfig
 * Author:   YJ
 * Date:     2020/11/27 11:15
 * Description: spring security 配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/27 11:15        1.0              描述
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 设置认证的数据源
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService) //设置认证的数据源
                .passwordEncoder(passwordEncoder()); //设置加方式
    }

    /**
     * 项容器中注入 AuthenticationManager，以供之后使用
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 设置过滤规则
     * <p>
     * formLogin：采用表单验证
     * loginProcessingUrl：指定处理登录验证的路径
     * loginPage：指定访问登录界面的url
     * failureForwardUrl:指定失败后跳转的界面
     * successForwardUrl；指定成功后的条状
     * 以上是采用系统默认的认证方式
     * @param http
     * @throws Exception
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                //设置 表单 处理
//                .formLogin()
//                //定义登录请求处理路径，如果程序重写了该接口，则表示采用自定义的结构处理
//                //spring security 会监听该请求，作为登录验证的请求，而不是采取自已定义的 Controller，理解错了
//                //如果不设置该路径，则默认的拦截路径为/login，
//                .loginProcessingUrl("/auth/login")
//                .loginPage("/login")//设置登录界面请求路径
//                .failureForwardUrl("/error")
//                .successForwardUrl("/success")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login")
//                .permitAll();
//    }


    /**
     * 采用定义的方式处理登录请求信息
     * /home 欢迎
     * <p>
     * /auth/login 登录处理请求
     * <p>
     * /login：登录界面
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/auth/login", "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();

    }
}
