package com.allong.web.controller;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitBinderController {

    @RequestMapping("/initBinder")
    public String initBinder(){
        return "success";
    }

    /**
     * 初始化数据绑定器，用来指定数据解析规则
     * <desc>
     * @InitBinder 只在对应的Controller中起作用，其他controller中不起作用
     * </desc>
     * <desc>
     *     替代方法：
     *     可在需要转换的字段上添加@DateTimeFormat注解进行标记
     *     同时需要在配置类上开启@EnableWebMvc 注解导入相关类
     * </desc>
     * @param binder
     */
    @InitBinder
    public void initBinderMethod(WebDataBinder binder){
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }
}
