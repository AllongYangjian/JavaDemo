package com.allong.web.controller;

import com.allong.web.bean.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class RSETfulController {
    Map<Integer, User> map = new HashMap<>();

    @RequestMapping(method = RequestMethod.POST)
    public String saveUser(@RequestBody User user) {
//        map.put(user.getId(), user);
        System.err.println(user.toString());
        return "success";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody User user) {
        map.put(id, user);
        System.err.println(user.toString());
        return "success";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public User queryUser(@PathVariable Integer id) {
        return map.get(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public String deleteUser(@PathVariable Integer id) {
        map.remove(id);
        return "success";
    }
}
