package com.yj.common.domain;

import lombok.Data;

import java.util.Date;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Payload
 * Author:   yangjian
 * Date:     2020/10/27 23:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/27 23:25        1.0              描述
 */
@Data
public class Payload<T> {

    private String id;

    private T userInfo;

    private Date expiration;
}
