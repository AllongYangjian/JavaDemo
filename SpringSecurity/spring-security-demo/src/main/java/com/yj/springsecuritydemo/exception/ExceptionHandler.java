package com.yj.springsecuritydemo.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: ExceptionHandler
 * Author:   yangjian
 * Date:     2020/10/14 23:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/14 23:25        1.0              描述
 */
//@Component
//public class ExceptionHandler implements HandlerExceptionResolver {
//
//    @Override
//    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("errorMsg", e.getMessage());
//        if (e instanceof AccessDeniedException) {
//            mv.setViewName("redirect:/403");
//        } else {
//            mv.setViewName("redirect:/500");
//        }
//        return mv;
//    }
//}
