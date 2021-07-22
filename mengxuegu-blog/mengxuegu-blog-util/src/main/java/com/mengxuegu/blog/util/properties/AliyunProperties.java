package com.mengxuegu.blog.util.properties;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: AliyunProperties
 * Author:   yangjian
 * Date:     2021/7/22 23:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/22 23:25        1.0              描述
 */
@Getter
@Setter
public class AliyunProperties implements Serializable {

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;

    private String bucketDomain;
}
