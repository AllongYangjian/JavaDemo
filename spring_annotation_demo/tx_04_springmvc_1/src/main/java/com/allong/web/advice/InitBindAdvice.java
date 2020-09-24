package com.allong.web.advice;

import com.allong.web.convert.StringToDateConvert;
import com.allong.web.exception.AgeException;
import com.allong.web.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * 全局增强
 * 用于在Controller执行添加通知
 * 被@InitBinder方法修饰的方法会被执行，所有的请求都会添加自定义转换器，
 * 是@InitBinder实现全局配置的解决方法
 */
@ControllerAdvice
public class InitBindAdvice {

    @Autowired
    private StringToDateConvert convert;

    @InitBinder
    public void initBinderMethod(WebDataBinder binder) {
//        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
        ConversionService service = binder.getConversionService();
        if(service instanceof GenericConversionService){
            ((GenericConversionService)service).addConverter(convert);
        }
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Model model, Exception e) {
        String msg = null;
        if (e instanceof CustomerException) {
            msg = e.getMessage();
        } else if (e instanceof AgeException) {
            msg = e.getMessage();
        } else {
            msg = "服务器内部异常，请联系管理员";
        }
        model.addAttribute("errorMsg", msg);
        return "error";
    }
}
