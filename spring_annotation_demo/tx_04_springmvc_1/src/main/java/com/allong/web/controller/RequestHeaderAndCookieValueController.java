package com.allong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 获取消息头和cookievalue消息的请求测试
 */
@Controller
public class RequestHeaderAndCookieValueController {

    @RequestMapping("/userRequestHeader")
    public String getRequestHeader(@RequestHeader("Accept-Language")String language){
        System.err.println(language);
        return "success";
    }

    @RequestMapping("/userCookieValue")
    public String userCookieValue(@CookieValue(value = "JSESSIONID")String id){
        System.err.println(id);
        return "success";
    }
}
