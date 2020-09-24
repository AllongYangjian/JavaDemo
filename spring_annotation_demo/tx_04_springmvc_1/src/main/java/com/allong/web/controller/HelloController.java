package com.allong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        System.err.println("控制器方法执行了");
        return "success";
    }
}
