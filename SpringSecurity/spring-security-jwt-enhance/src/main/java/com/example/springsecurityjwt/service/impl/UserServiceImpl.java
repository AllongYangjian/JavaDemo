package com.example.springsecurityjwt.service.impl;

import com.example.springsecurityjwt.mapper.UserMapper;
import com.example.springsecurityjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: UserServiceImpl
 * Author:   YJ
 * Date:     2020/11/27 11:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/27 11:12        1.0              描述
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails details = userMapper.findUser(s);
        System.err.println(details.toString());
        return userMapper.findUser(s);
    }
}
