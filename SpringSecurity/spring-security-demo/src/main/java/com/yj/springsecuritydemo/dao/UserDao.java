package com.yj.springsecuritydemo.dao;

import com.yj.springsecuritydemo.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: UserDao
 * Author:   yangjian
 * Date:     2020/10/13 21:55
 * Description: 用户信息Dao层接口
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/13 21:55        1.0              描述
 */
public interface UserDao {
    @Select("select * from sys_user where username = #{name}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "roles",column = "id",javaType = List.class,
                    many = @Many(select="com.yj.springsecuritydemo.mapper.RoleMapper.findByUid"))
    })
    SysUser findByName(String name);
}
