package com.mengxuegu.blog.util.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: BlogProperties
 * Author:   yangjian
 * Date:     2021/7/22 23:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/22 23:17        1.0              描述
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "mengxuegu.blog")
public class BlogProperties implements Serializable {

    private AliyunProperties aliyun;
}
