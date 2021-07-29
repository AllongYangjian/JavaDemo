package com.mengxuegu.blog.system.feign;

import com.mengxuegu.blog.entities.Menu;
import com.mengxuegu.blog.entities.User;
import com.mengxuegu.blog.feign.IFeignSystemController;
import com.mengxuegu.blog.system.service.IMenuService;
import com.mengxuegu.blog.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: FeignSystemController
 * Author:   yangjian
 * Date:     2021/7/29 22:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/29 22:23        1.0              描述
 */
@RestController
public class FeignSystemController implements IFeignSystemController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IMenuService menuService;

    @Override
    public User findUserByUsername(String username) {
        return userService.findByUsername(username);
    }

    @Override
    public List<Menu> findMenuListByUserId(String userId) {
        return menuService.findByUserId(userId);
    }
}
