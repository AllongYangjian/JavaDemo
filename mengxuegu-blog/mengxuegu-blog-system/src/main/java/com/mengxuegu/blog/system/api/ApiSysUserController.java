package com.mengxuegu.blog.system.api;

import com.mengxuegu.blog.system.req.RegisterREQ;
import com.mengxuegu.blog.system.service.IUserService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "用户管理接口", description = "用户管理接口，不需要身份认证就可以调用下面接口")
@RestController
@RequestMapping("/api/user")
public class ApiSysUserController {

    @Autowired
    private IUserService sysUserService;

    @ApiImplicitParam(name = "username", value = "用户名", required = true)
    @ApiOperation("校验用户名是否存在接口")
    @GetMapping("/username/{username}") //  /api/user/username/{username}
    public Result checkUsername(@PathVariable("username") String username) {
        return sysUserService.checkUsername(username);
    }

    @ApiOperation("注册用户接口")
    @PostMapping("/register") // /api/user/register
    public Result register(@RequestBody RegisterREQ req) {
        return sysUserService.register(req);
    }

}
