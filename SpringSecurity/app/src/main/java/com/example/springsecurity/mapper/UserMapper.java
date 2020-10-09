package com.example.springsecurity.mapper;

import com.example.springsecurity.domain.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: UserMapper
 * Author:   YJ
 * Date:     2020/10/9 21:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/10/9 21:28        1.0              描述
 */
public interface UserMapper extends Mapper<SysUser> {

    @Select("select * from sys_user where username = #{username}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roles",column = "id",javaType = List.class,
            many = @Many(select="com.example.springsecurity.mapper.RoleMapper.findByUid"))
    })
    SysUser findByName(String username);
}
