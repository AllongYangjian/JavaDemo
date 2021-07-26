package com.mengxuegu.blog.system.mapper;

import com.mengxuegu.blog.entities.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 角色信息表 Mapper 接口
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
public interface RoleMapper extends BaseMapper<Role> {


    /**
     * 通过角色id删除角色菜单关系表数据
     * @param roleId 角色id
     * @return
     */
    boolean deleteRoleMenuByRoleId(@Param("roleId")String roleId);
}
