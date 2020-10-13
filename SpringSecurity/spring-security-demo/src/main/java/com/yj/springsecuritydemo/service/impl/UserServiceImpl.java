package com.yj.springsecuritydemo.service.impl;

import com.yj.springsecuritydemo.dao.UserDao;
import com.yj.springsecuritydemo.domain.SysRole;
import com.yj.springsecuritydemo.domain.SysUser;
import com.yj.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: UserServiceImpl
 * Author:   yangjian
 * Date:     2020/10/13 21:54
 * Description: 用户信息服务实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/13 21:54        1.0              描述
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            SysUser user = userDao.findByName(username);
            System.err.println(user.toString());
            if (user == null) {
                return null;
            }
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            List<SysRole> roles = user.getRoles();
            for (SysRole role : roles) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
            UserDetails userDetails = new User(user.getUsername(), user.getPassword(), authorities);
            return userDetails;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
