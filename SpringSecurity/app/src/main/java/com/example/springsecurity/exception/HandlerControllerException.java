package com.example.springsecurity.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: HandlerControllerException
 * Author:   YJ
 * Date:     2020/10/9 23:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/10/9 23:16        1.0              描述
 */
@ControllerAdvice
public class HandlerControllerException {

    @ExceptionHandler(RuntimeException.class)
    public String handException(RuntimeException e){
        if(e instanceof AccessDeniedException){
            return "redirect:/403";
        }else{
            return "redirect:/500";
        }
    }
}
