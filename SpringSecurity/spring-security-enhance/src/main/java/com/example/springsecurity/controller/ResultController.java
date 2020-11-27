package com.example.springsecurity.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: SuccessController
 * Author:   YJ
 * Date:     2020/11/27 14:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/27 14:05        1.0              描述
 */
@RequestMapping
@Controller
public class ResultController {

    @PostMapping("/success")
    public String success() {
        return "success";
    }
}
