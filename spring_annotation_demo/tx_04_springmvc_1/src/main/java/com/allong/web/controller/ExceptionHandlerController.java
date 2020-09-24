package com.allong.web.controller;

import com.allong.web.exception.AgeException;
import com.allong.web.exception.CustomerException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionHandlerController {

    @RequestMapping("/userExceptionHandler")
    public String userExceptionHandler(Integer age) throws CustomerException, AgeException {
        if(age == null){
            throw new NullPointerException();
        }
        if(age<0){
            throw new AgeException("年龄不能为负数");
        }
        if (age > 100) {
            throw new CustomerException("年龄不合法");
        }
        return "success";
    }

    /**
     * 如果该方法使用在Controller内部，则表明智慧处理该Controller中的方法，
     * 如果是用在@ControllerAdvice修饰的内中，则表示处理全局异常
     * @param model
     * @param e
     * @return
     */
//    @ExceptionHandler(Exception.class)
//    public String handleException(Model model, Exception e) {
//        String msg = null;
//        if (e instanceof CustomerException) {
//            msg = e.getMessage();
//        } else {
//            msg = "服务器内部异常，请联系管理员";
//        }
//        model.addAttribute("errorMsg",msg);
//        return "error";
//    }
}
