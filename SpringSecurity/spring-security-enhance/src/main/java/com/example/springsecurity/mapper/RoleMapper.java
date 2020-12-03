package com.example.springsecurity.mapper;

import com.example.springsecurity.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: RoleMapper
 * Author:   YJ
 * Date:     2020/11/27 11:05
 * Description: 用户角色信息mapper
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/27 11:05        1.0              描述
 */
@Mapper
public interface RoleMapper {
    /**
     * 通过用户 id查询用户角色列表
     *
     * @param uid
     * @return
     */
    @Select("select sr.* from sys_role sr left join sys_user_role sur on sr.id = sur.rid " +
            "where sur.uid = #{uid}")
    List<SysRole> findUserRoles(Integer uid);
}
