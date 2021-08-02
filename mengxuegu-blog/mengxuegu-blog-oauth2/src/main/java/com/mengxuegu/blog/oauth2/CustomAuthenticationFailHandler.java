package com.mengxuegu.blog.oauth2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mengxuegu.blog.util.base.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: CustomAuthenticationSuccessHandler
 * Author:   yangjian
 * Date:     2021/8/2 21:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/8/2 21:59        1.0              描述
 */
@Component("customAuthenticationFailHandler")
public class CustomAuthenticationFailHandler implements AuthenticationFailureHandler {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        logger.error("登陆失败处理器{}",e.getMessage());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(Result.error(e.getMessage())));
    }
}
