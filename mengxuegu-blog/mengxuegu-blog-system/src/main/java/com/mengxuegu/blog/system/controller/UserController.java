package com.mengxuegu.blog.system.controller;


import com.mengxuegu.blog.system.req.SysUserREQ;
import com.mengxuegu.blog.system.service.IUserService;
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
 * 用户信息表 前端控制器
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
@Api(value = "用户管理接口", description = "用户管理接口, 提供用户的增删改查")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService sysUserService;

    @ApiOperation("根据用户名和手机号查询用户列表接口")
    @PostMapping("/search")
    public Result search(@RequestBody SysUserREQ req) {
        return sysUserService.queryPage(req);
    }
}
