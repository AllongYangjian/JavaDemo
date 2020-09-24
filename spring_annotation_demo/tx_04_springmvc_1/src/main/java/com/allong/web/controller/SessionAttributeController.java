package com.allong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("message")//往回话域中存入数据
public class SessionAttributeController {

    /**
     * 往session域中存入数据
     * 在没有SessionAttribute注解时，当控制器方法的参数有Model，ModelMap时是默认往请求域中存入数据
     *
     * @return
     */
    @RequestMapping("/userSessionAttributes")
    public String userSessionAttributeSet(Model model){
        model.addAttribute("message","sb");
        return "success";
    }

    //从会话域中获取数据
    @RequestMapping("/userSessionAttribute")
    public String userSessionAttributeGet(@SessionAttribute("message")String msg){
        System.err.println(msg);
        return "success";
    }
}
