package com.yj.springsecuritydemo.mapper;

import com.yj.springsecuritydemo.domain.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: UserMapper
 * Author:   yangjian
 * Date:     2020/10/13 22:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/13 22:46        1.0              描述
 */
public interface UserMapper extends Mapper<SysUser> {

    @Select("select * from sys_user where username = #{name}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roles",column = "id",javaType = List.class,
                    many = @Many(select="com.yj.springsecuritydemo.mapper.RoleMapper.findByUid"))
    })
    SysUser findByName(String name);

}
