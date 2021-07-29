package com.mengxuegu.blog.feign;

import com.mengxuegu.blog.entities.Menu;
import com.mengxuegu.blog.entities.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: IFeignSystemController
 * Author:   yangjian
 * Date:     2021/7/29 22:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/29 22:19        1.0              描述
 */
@FeignClient(value = "system-server",path = "/system")
public interface IFeignSystemController {

    @ApiImplicitParam(name = "username",value = "用户名",required = true)
    @GetMapping("/api/feign/user/{username}")
    @ApiOperation("通过用户名查询用户信息")
    User findUserByUsername(@PathVariable("username")String username);

    @ApiOperation("通过用户id查询所拥有的权限")
    @ApiImplicitParam(name = "userId",value = "用户ID",required = true)
    @GetMapping("/api/feign/menu/{userId}")
    List<Menu> findMenuListByUserId(@PathVariable("userId")String userId);
}
