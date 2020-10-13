package com.yj.springsecuritydemo.dao;

import com.yj.springsecuritydemo.domain.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: RoleDao
 * Author:   yangjian
 * Date:     2020/10/13 22:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/13 22:58        1.0              描述
 */
public interface RoleDao {
    @Select("select r.id,r.role_name roleName,r.role_desc roleDesc " +
            "from sys_role r,sys_user_role u where r.id = u.rid and u.uid = #{uid}")
    List<SysRole> findByUid(Integer uid);
}
