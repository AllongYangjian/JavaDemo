package com.mengxuegu.blog.oauth2.service;

import com.mengxuegu.blog.entities.Menu;
import com.mengxuegu.blog.entities.User;
import com.mengxuegu.blog.feign.IFeignSystemController;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: UserDetailServiceImpl
 * Author:   yangjian
 * Date:     2021/7/29 22:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/29 22:28        1.0              描述
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IFeignSystemController feignSystemController;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new BadCredentialsException("用户名不能为空");
        }
        User user = feignSystemController.findUserByUsername(username);
        if (user == null) {
            throw new BadCredentialsException("用户名或密码错误");
        }
        List<Menu> menuList = feignSystemController.findMenuListByUserId(user.getId());
        List<GrantedAuthority> authorities = null;
        if (CollectionUtils.isNotEmpty(menuList)) {
            authorities = new ArrayList<>();
            for (Menu item : menuList) {
                authorities.add(new SimpleGrantedAuthority(item.getCode()));
            }
        }
        JwtUser jwtUser = new JwtUser(user.getId(), user.getUsername(), user.getPassword(), user.getNickName(),
                user.getImageUrl(), user.getMobile(), user.getEmail(), user.getIsAccountNonExpired(),
                user.getIsAccountNonExpired(), user.getIsCredentialsNonExpired(), user.getIsEnabled(), authorities);
        return jwtUser;
    }
}
