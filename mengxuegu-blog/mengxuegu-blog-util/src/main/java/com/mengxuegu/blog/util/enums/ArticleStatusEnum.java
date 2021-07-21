package com.mengxuegu.blog.util.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ArticleStatusEnum
 * Author:   yangjian
 * Date:     2021/7/21 21:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/21 21:20        1.0              描述
 */
@Getter
@AllArgsConstructor
public enum ArticleStatusEnum {
    DELETE(0,"已删除"),
    WAIT(1,"待审核"),
    SUCCESS(2,"审核通过"),
    FAIL(4,"审核未通过");
    private Integer code;

    private String desc;
}
