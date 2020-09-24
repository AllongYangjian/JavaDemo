package com.jiancode.springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.HashMap;
import java.util.Map;

/**
 * Description：TODO
 * author：yj
 * email：yj@allong.net
 * date：2019-06-26 10:29
 * version：1.0
 */
public class PDFController extends AbstractController {

    protected ModelAndView handleRequestInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        Map<String ,String> userData = new HashMap<String,String>();
        userData.put("100","Xiao.Lu");
        userData.put("102","User 102");
        userData.put("103","User 103");
        userData.put("104","User 104");
        return new ModelAndView("UserSummary","userData",userData);
    }
}
