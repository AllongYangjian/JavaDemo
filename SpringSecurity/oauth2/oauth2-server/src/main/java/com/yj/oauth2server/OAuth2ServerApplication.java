package com.yj.oauth2server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: OAuth2ServerApplication
 * Author:   YJ
 * Date:     2020/11/2 17:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/2 17:18        1.0              描述
 */
@SpringBootApplication
@MapperScan("com.yj.oauth2server.mapper")
public class OAuth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class, args);
    }
}
