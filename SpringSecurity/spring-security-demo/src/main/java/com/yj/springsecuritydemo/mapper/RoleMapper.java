package com.yj.springsecuritydemo.mapper;

import com.yj.springsecuritydemo.domain.SysRole;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: RoleMapper
 * Author:   yangjian
 * Date:     2020/10/13 22:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/13 22:51        1.0              描述
 */
public interface RoleMapper extends Mapper<SysRole> {

    @Select("select r.id,r.role_name roleName,r.role_desc roleDesc " +
            "from sys_role r,sys_user_role u where r.id = u.rid and u.uid = #{uid}")
    List<SysRole> findByUid(Integer uid);
}
