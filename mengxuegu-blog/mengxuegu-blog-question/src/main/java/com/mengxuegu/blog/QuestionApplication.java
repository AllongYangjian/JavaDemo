package com.mengxuegu.blog;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: QuestionApplication
 * Author:   yangjian
 * Date:     2021/7/25 15:18
 * Description: 4
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/25 15:18        1.0              描述
 */
@SpringBootApplication
@EnableSwagger2Doc
@EnableDiscoveryClient
@MapperScan("com.mengxuegu.blog.question.mapper")
public class QuestionApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionApplication.class, args);
    }
}
