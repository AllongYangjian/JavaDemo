package com.mengxuegu.blog;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: SystemApplication
 * Author:   yangjian
 * Date:     2021/7/26 21:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/26 21:46        1.0              描述
 */
@EnableSwagger2Doc
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }
}
