package com.example.springsecurityjwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
//    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>("查询成功", HttpStatus.OK);
    }

}
