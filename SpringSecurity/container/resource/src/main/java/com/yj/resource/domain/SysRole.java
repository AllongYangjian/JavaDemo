package com.yj.resource.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: SysRole
 * Author:   yangjian
 * Date:     2020/10/28 22:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/28 22:49        1.0              描述
 */
@Data
public class SysRole implements GrantedAuthority {

    private Integer id;

    private String roleName;

    private String roleDesc;

    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleName;
    }
}
