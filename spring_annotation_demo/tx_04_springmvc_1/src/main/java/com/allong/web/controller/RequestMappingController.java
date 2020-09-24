package com.allong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingController {

    @RequestMapping(value = "/userRequestMapping",method = RequestMethod.GET)
    public String userRequestMapping(){
        System.err.println("userRequestMapping");
        return "success";
    }

    @RequestMapping(value = "/userRequestMapping",method = RequestMethod.DELETE)
    public String userRequestMappingDeleteMethod(){
        System.err.println("userRequestMapping");
        return "success";
    }
}
