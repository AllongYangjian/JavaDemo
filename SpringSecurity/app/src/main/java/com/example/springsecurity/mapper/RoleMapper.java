package com.example.springsecurity.mapper;

import com.example.springsecurity.domain.SysRole;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: RoleMapper
 * Author:   YJ
 * Date:     2020/10/9 21:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/10/9 21:33        1.0              描述
 */
public interface RoleMapper extends Mapper<SysRole> {

    @Select("select r.id,r.role_name roleName,r.role_desc roleDesc" +
            "    from sys_role r,sys_user_role ur where r.id = ur.rid and ur.uid = #{id}")
    List<SysRole> findByUid(Integer id);
}
