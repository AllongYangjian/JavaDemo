package com.mengxuegu.blog.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mengxuegu.blog.entities.Menu;
import com.mengxuegu.blog.system.mapper.MenuMapper;
import com.mengxuegu.blog.system.req.SysMenuREQ;
import com.mengxuegu.blog.system.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengxuegu.blog.util.base.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单信息表 服务实现类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Override
    public Result queryList(SysMenuREQ req) {
        // 1. 条件查询所有菜单
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(req.getName())) {
            wrapper.like("name", req.getName());
        }

        // 将按sort升序，再update_date降序
        wrapper.orderByAsc("sort").orderByDesc("update_date");

        List<Menu> menuList = baseMapper.selectList(wrapper);

        // 2. 将菜单封装为树状结构
        List<Menu> sysMenus = this.buildTree(menuList);
        return Result.ok( sysMenus );
    }

    /**
     *  将菜单封装为树状结构
     * @param menuList 所有的菜单（目录、菜单、按钮）
     * @return 返回已经构建好树菜单集合
     */
    private List<Menu> buildTree(List<Menu> menuList) {
        // 1. 获取根菜单
        List<Menu> rootMenuList = new ArrayList<>();
        for(Menu menu: menuList) {
            // parentId=0为根菜单
            if(menu.getParentId().equals("0")) {
                rootMenuList.add(menu);
            }
        }
        // 2. 根菜单下的子菜单
        for(Menu menu: rootMenuList) {
            // 获取一个个根菜单，获取后再去获取对应的子菜单
            childrenMenu(menuList, menu);
        }
        // 所有根菜单对象中都将子菜单收集在了对应的children对象中
        return rootMenuList;
    }


    /**
     * 博客管理》标签管理、文章管理
     * 判断父菜单id是否等于所有菜单中的某一个菜单的parentId，如果等于，则这个菜单 就是子菜单
     * @param menuList 所有菜单（目录、菜单、按钮）
     * @param menu 父菜单对象
     * @return
     */
    private Menu childrenMenu(List<Menu> menuList, Menu menu) {
        // 存放menu菜单对象的所有子菜单
        List<Menu> children = new ArrayList<>();
        // 循环所有菜单，判断是否为 menu 的子菜单
        for(Menu m: menuList) {
            // 判断每个菜单的parentId是否等于menu对象中的id
            if(m.getParentId().equals( menu.getId() )) {
                children.add( childrenMenu(menuList, m) );
            }
        }
        menu.setChildren(children);
        return menu;
    }
}
