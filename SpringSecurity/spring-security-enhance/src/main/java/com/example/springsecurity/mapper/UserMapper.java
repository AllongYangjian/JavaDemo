package com.example.springsecurity.mapper;

import com.example.springsecurity.domain.SysUser;
import org.apache.ibatis.annotations.*;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: UserMapper
 * Author:   YJ
 * Date:     2020/11/27 11:04
 * Description: 用户信息mapper
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/27 11:04        1.0              描述
 */
@Mapper
public interface UserMapper {

    @Select("select * from sys_user where username = #{username}")
    @Results({
            @Result(column = "id",property = "roles",many = @Many(select = "com.example.springsecurity.mapper.RoleMapper.findUserRoles"))
    })
    SysUser findUser(String username);
}
