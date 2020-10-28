package com.yj.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: TestController
 * Author:   YJ
 * Date:     2020/10/20 10:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/10/20 10:34        1.0              描述
 */
@Controller
public class TestController {

    public final String path = "test/";

    @RequestMapping("/test")
    public String test() {
        return path + "index";
    }

}
