package com.mengxuegu.blog.system.mapper;

import com.mengxuegu.blog.entities.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
public interface UserMapper extends BaseMapper<User> {


    /**
     * 根据用户id查询当前用户所拥有的角色ids
     * @param id 用户id
     * @return
     */
    List<String> findRoleIdsById(@Param("id") String id);

    /**
     * 通过用户id删除用户角色关系表数据
     * @param userId 用户id
     * @return
     */
    boolean deleteUserRoleByUserId(@Param("userId") String userId);

    /**
     * 新增用户角色关系 表数据
     * @param userId 用户id
     * @param roleIds 角色id集合
     * @return
     */
    boolean saveUserRole(@Param("userId") String userId,
                         @Param("roleIds") List<String> roleIds);
}
