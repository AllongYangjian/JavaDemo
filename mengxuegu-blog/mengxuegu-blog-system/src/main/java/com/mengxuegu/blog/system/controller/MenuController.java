package com.mengxuegu.blog.system.controller;


import com.mengxuegu.blog.system.req.SysMenuREQ;
import com.mengxuegu.blog.system.service.IMenuService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 菜单信息表 前端控制器
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
@Api(value = "菜单管理接口", description = "菜单管理接口，提供菜单的增删改查接口")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService sysMenuService;

    @ApiOperation("根据菜单名称查询列表接口")
    @PostMapping("/search") // localhost:8003/system/menu/search
    public Result search(@RequestBody SysMenuREQ req) {
        return sysMenuService.queryList(req);
    }

}
