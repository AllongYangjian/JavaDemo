package com.mengxuegu.blog.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ResultEnum
 * Author:   yangjian
 * Date:     2021/7/19 21:23
 * Description:统一响应结果类
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/19 21:23        1.0              描述
 */
@Getter
@AllArgsConstructor
public enum  ResultEnum {

    SUCCESS(20000,"成功"),

    ERROR(999,"错误"),

    UNAUTHENTICATED(401,"请先通过身份认证"),

    AUTH_FAIL(1400,"认证失败"),

    TOKEN_PAST(1401,"身份过期，请重新登录"),

    TOKEN_ERROR(1402,"令牌错误"),

    HEADER_ERROR(1403,"请求头错误"),

    AUTH_USERNAME_NONE(1405,"用户名不能为空"),

    AUTH_PASSWORD_NONE(1406,"密码不能为空"),

    MENU_NO(306,"没有权限，请联系管理员");

    private int code;

    private String desc;
}
