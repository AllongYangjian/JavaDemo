package com.yj.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Oauth2SourceApplication
 * Author:   YJ
 * Date:     2020/11/2 11:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/2 11:37        1.0              描述
 */
@SpringBootApplication
@MapperScan("com.yj.oauth2.mapper")
public class Oauth2SourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2SourceApplication.class, args);
    }
}
