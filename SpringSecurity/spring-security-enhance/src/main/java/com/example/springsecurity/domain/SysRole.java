package com.example.springsecurity.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: SysRole
 * Author:   YJ
 * Date:     2020/11/27 11:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/27 11:01        1.0              描述
 */
@Getter
@Setter
public class SysRole implements GrantedAuthority {

    private Integer id;

    private String roleName;

    private String roleDesc;


    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleName;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
