package com.example.springsecurityjwt.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: SysUser
 * Author:   YJ
 * Date:     2020/11/27 11:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/27 11:00        1.0              描述
 */
@Getter
@Setter
public class SysUser implements UserDetails {

    private Integer id;

    private String username;

    private String password;

    private Integer status;

    private List<SysRole> roles;

    @JsonIgnore
    @JSONField(deserialize = false, serialize = false)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @JsonIgnore
    @JSONField(deserialize = false, serialize = false)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @JSONField(deserialize = false, serialize = false)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @JSONField(deserialize = false, serialize = false)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @JSONField(deserialize = false, serialize = false)
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", roles=" + roles +
                '}';
    }
}
