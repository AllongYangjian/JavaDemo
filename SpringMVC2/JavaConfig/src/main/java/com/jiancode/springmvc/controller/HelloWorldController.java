package com.jiancode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description：TODO
 * author：yj
 * email：yj@allong.net
 * date：2019-06-26 13:48
 * version：1.0
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

    @RequestMapping("/hello")
    public String sayHello(ModelMap model){
        model.addAttribute("greeting","Hello World From Spring MVC");
        return "welcome";
    }
}
