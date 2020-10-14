package com.yj.springsecuritydemo.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: ExceptionHandler2
 * Author:   yangjian
 * Date:     2020/10/14 23:34
 * Description: 全局异常处理
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/14 23:34        1.0              描述
 */
@ControllerAdvice
public class ExceptionHandler2 {

    @ExceptionHandler(AccessDeniedException.class)
    public String exp() {
        return "redirect:/403";
    }

    @ExceptionHandler(RuntimeException.class)
    public String exp2() {
        return "redirect:/500";
    }
}
