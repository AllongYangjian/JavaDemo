package com.mengxuegu.blog.system.service;

import com.mengxuegu.blog.entities.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.system.req.SysUserREQ;
import com.mengxuegu.blog.util.base.Result;

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

}
