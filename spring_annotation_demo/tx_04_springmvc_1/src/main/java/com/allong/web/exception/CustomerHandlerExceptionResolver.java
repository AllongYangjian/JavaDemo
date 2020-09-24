package com.allong.web.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常解析器
 * 1、自定义类实现 HandlerExceptionResolver 接口
 * 2、将类添加到ioc容器
 * 说明：
 * 这种方式只能不成处理参数绑定产生的异常，
 * 而使用@ControllerAdvice和@ExceptionHandler可以处理参数产生的异常
 * 因此不推荐使用这种方式
 */
//@Component
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        ModelAndView mv = new ModelAndView();
        String msg = null;
        if (e instanceof CustomerException) {
            msg = e.getMessage();
        } else if (e instanceof AgeException) {
            msg = e.getMessage();
        } else {
            msg = "服务器内部异常，请联系管理员";
        }
        mv.addObject("errorMsg",msg);
        mv.setViewName("error");
        return mv;
    }
}
