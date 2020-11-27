package com.example.springsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: TestController
 * Author:   YJ
 * Date:     2020/11/27 11:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/27 11:13        1.0              描述
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/findAll")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>("查询成功", HttpStatus.OK);
    }

}
