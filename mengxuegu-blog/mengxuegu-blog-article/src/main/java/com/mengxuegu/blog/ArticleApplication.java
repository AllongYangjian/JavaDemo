package com.mengxuegu.blog;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ArticleApplication
 * Author:   yangjian
 * Date:     2021/7/19 22:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/19 22:32        1.0              描述
 */
@SpringBootApplication
@EnableSwagger2Doc
@EnableDiscoveryClient
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class,args);
    }
}
