package com.example.test.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: AntDesignController
 * Author:   YJ
 * Date:     2020/8/11 12:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/8/11 12:13        1.0              描述
 */
@Controller
public class AntDesignController implements ErrorController {

    @RequestMapping(value = "/error")
    public String getIndex(){
        return "index"; //返回index页面
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }

}
