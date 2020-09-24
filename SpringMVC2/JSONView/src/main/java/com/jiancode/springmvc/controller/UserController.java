package com.jiancode.springmvc.controller;

import com.jiancode.springmvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description：TODO
 * author：yj
 * email：yj@allong.net
 * date：2019-06-26 11:23
 * version：1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "{name}")
    @ResponseBody
    public User getUser(@PathVariable("name") String name) {
        User user = new User();
        user.setName(name);
        user.setAddress(System.currentTimeMillis() + "");
        return user;
    }

}
