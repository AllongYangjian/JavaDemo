package com.yj.springsecuritydemo.config;

import com.yj.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;

import javax.sql.DataSource;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: WebScecurityConfig
 * Author:   yangjian
 * Date:     2020/10/12 22:31
 * Description: SpringSecurity配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/12 22:31        1.0              描述
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 配置访问路径过滤规则
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //开启记住密码功能 当关闭浏览器后再次打开网页不需要输入用户名密码就可以登录
        //退出的时候不要点击注销功能，否则无法实现
        //核心原理是存库tooken信息到Cookie
        http.rememberMe().tokenValiditySeconds(60)
                .rememberMeServices(rememberMeServices()) //将remember token持久化到数据库
                .key("INTERNAL_SECRET_KEY");
        ;

        http.authorizeRequests()//验证所有的请求
                .antMatchers("/", "/home").permitAll()//添加无需验证的url
//                .antMatchers("/product/findAll").hasRole("ADMIN")//配置权限信息
                .anyRequest().authenticated()//
                .and()
                .formLogin()
                .loginPage("/login").permitAll()//登录页面无需过滤
                .and()
                .logout()
                .permitAll();

    }

    @Autowired
    private DataSource dataSource;

    @Bean
    public RememberMeServices rememberMeServices() {
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
        repository.setDataSource(dataSource);
        PersistentTokenBasedRememberMeServices rememberMeServices =
                new PersistentTokenBasedRememberMeServices("INTERNAL_SECRET_KEY", userDetailsService(), repository);
        rememberMeServices.setParameter("remember-me");
        return rememberMeServices;
    }

    @Autowired
    private UserService service;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withUsername("root")
//                .password("{noop}123")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
        return service;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }
}
