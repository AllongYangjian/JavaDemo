package com.yj.resource;

import com.yj.resource.config.RsaKeyProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: ResourceApplication
 * Author:   yangjian
 * Date:     2020/10/29 0:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/29 0:42        1.0              描述
 */
@SpringBootApplication
@EnableConfigurationProperties(value = RsaKeyProperties.class)
@MapperScan("com.yj.springjwtrsamybatis.mapper")
public class ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }
}