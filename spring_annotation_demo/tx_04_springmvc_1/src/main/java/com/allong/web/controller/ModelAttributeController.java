package com.allong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ModelAttribute
 * 他可以用来修饰方法或参数
 * 修饰方法：标志执行控制器方法执行，被此注解修饰的方法都会被执行
 * 修饰参数：用户获取指定的数据给参数赋值
 */
@Controller
public class ModelAttributeController {

    /**
     * 该方法会在所有请求的方法执行之前被执行
     * @param name
     * @param model 出参，用来添加属性值
     */
    @ModelAttribute
    public void showModel(String name, Model model){
        System.err.println("show model method name is:"+name);
        //修改属性值并将参数存入以便再次使用
        model.addAttribute("name",name+" <>");
    }


    @RequestMapping("/userModelAttribute")
    public String userModelAttribute(@ModelAttribute(value = "name") String name){
        //通过@ModelAttribute属性获取传入的属性值
        System.err.println("controller model method name is:"+name);
        return "success";
    }

    @RequestMapping("/userModelAttribute2")
    public String userModelAttribute2(String name){
        System.err.println("controller model method name is:"+name);
        return "success";
    }

    //替代方案
    //使用返回值代替Model参数，同时制定存放时对应的名称
//    @ModelAttribute("username")
//    public String showModel(String name){
//        System.err.println("show model method name is:"+name);
//        //修改属性值并将参数存入以便再次使用
//       return name+"sb;
//    }
//
        //从参数集合中取出值
//    @RequestMapping("/userModelAttribute2")
//    public String userModelAttribute2(@ModelAttribute("username") String name){
//        System.err.println("controller model method name is:"+name);
//        return "success";
//    }

}
