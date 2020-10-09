package com.example.springsecurity.service.impl;

import com.example.springsecurity.mapper.UserMapper;
import com.example.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: UserServiceImpl
 * Author:   YJ
 * Date:     2020/10/9 21:39
 * Description: 用户实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/10/9 21:39        1.0              描述
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return userMapper.findByName(s);
    }
}
