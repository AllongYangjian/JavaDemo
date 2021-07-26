package com.mengxuegu.blog.system.service;

import com.mengxuegu.blog.entities.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.system.req.SysMenuREQ;
import com.mengxuegu.blog.util.base.Result;

/**
 * <p>
 * 菜单信息表 服务类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 条件查询菜单列表
     * @param req
     * @return
     */
    Result queryList(SysMenuREQ req);

    /**
     * 根据菜单id删除
     * @param id 菜单id
     * @return
     */
    Result deleteById(String id);

    /**
     * 通过用户id查询所拥有的权限菜单树
     * @param userId
     * @return
     */
    Result findUserMenuTree(String userId);
}
