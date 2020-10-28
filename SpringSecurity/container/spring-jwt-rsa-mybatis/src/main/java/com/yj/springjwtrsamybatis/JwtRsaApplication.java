package com.yj.springjwtrsamybatis;

import com.yj.springjwtrsamybatis.config.RsaKeyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: JwtRsaApplication
 * Author:   yangjian
 * Date:     2020/10/28 0:46
 * Description: App
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/28 0:46        1.0              描述
 */
@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
@MapperScan("com.yj.springjwtrsamybatis.mapper")
public class JwtRsaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtRsaApplication.class, args);
    }
}
