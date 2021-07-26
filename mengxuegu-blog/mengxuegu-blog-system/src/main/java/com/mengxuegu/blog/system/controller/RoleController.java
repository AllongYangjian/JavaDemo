package com.mengxuegu.blog.system.controller;


import com.mengxuegu.blog.entities.Role;
import com.mengxuegu.blog.system.req.SysRoleREQ;
import com.mengxuegu.blog.system.service.IRoleService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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


    @ApiOperation("新增角色信息接口")
    @PostMapping
    public Result save(@RequestBody Role sysRole) {
        sysRoleService.save(sysRole);
        return Result.ok();
    }

    @ApiImplicitParam(name = "id", value = "角色ID", required = true)
    @ApiOperation("查询角色详情接口")
    @GetMapping("/{id}")
    public Result view(@PathVariable("id") String id) {
        return Result.ok( sysRoleService.getById(id) ) ;
    }

    @ApiOperation("更新角色信息接口")
    @PutMapping
    public Result update(@RequestBody Role sysRole) {
        sysRole.setUpdateDate(new Date());
        sysRoleService.updateById(sysRole);
        return Result.ok();
    }

    @ApiImplicitParam(name = "id", value = "角色ID", required = true)
    @ApiOperation("删除角色信息及角色菜单关系接口")
    @DeleteMapping("/{id}") // /system/role/1
    public Result delete(@PathVariable("id") String id) {
        return sysRoleService.deleteById(id);
    }

}
