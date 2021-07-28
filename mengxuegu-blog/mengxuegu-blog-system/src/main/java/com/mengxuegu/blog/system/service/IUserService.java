package com.mengxuegu.blog.system.service;

import com.mengxuegu.blog.entities.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.system.req.SysUserREQ;
import com.mengxuegu.blog.util.base.Result;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
public interface IUserService extends IService<User> {

    /**
     * 条件分页查询用户列表
     * @param req
     * @return
     */
    Result queryPage(SysUserREQ req);


    /**
     * 根据用户id查询当前用户所拥有的角色ids
     * @param id 用户id
     * @return
     */
    Result findRoleIdsById(String id);

    /**
     * 新增用户角色关系表数据
     * @param userId 用户id
     * @param roleIds 角色id集合
     * @return
     */
    Result saveUserRole(String userId, List<String> roleIds);

    /**
     * 根据用户id进行删除，假删除，将is_enabled 状态值更新为0
     * @param id 用户id
     * @return
     */
    Result deleteById(String id);
}
