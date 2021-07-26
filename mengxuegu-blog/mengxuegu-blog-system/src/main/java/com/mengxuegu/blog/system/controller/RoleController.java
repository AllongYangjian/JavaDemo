package com.mengxuegu.blog.system.controller;


import com.mengxuegu.blog.system.req.SysRoleREQ;
import com.mengxuegu.blog.system.service.IRoleService;
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
 * 角色信息表 前端控制器
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
@RestController
@RequestMapping("/role")
@Api(value = "角色管理接口", description = "角色管理接口，提供角色的增删改查")
public class RoleController {
    @Autowired
    private IRoleService sysRoleService;

    @ApiOperation("根据角色名称查询角色列表接口")
    @PostMapping("/search")
    public Result search(@RequestBody SysRoleREQ req) {
        return sysRoleService.queryPage(req);
    }
}
