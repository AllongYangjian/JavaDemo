package com.mengxuegu.blog.system.service;

import com.mengxuegu.blog.entities.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.system.req.SysRoleREQ;
import com.mengxuegu.blog.util.base.Result;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
public interface IRoleService extends IService<Role> {

    /**
     * 条件分页查询角色列表
     * @param req
     * @return
     */
    Result queryPage(SysRoleREQ req);

}
