package com.mengxuegu.blog.oauth2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mengxuegu.blog.util.base.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出成功处理器，清除redis中的数据
 */
@Component("customLogoutSuccessHandler")
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
       // 获取访问令牌
        String accessToken = request.getParameter("accessToken");
        if(StringUtils.isNotBlank(accessToken)) {
            OAuth2AccessToken oAuth2AccessToken =
                    tokenStore.readAccessToken(accessToken);
            if(oAuth2AccessToken != null) {
                // 删除redis中对应的访问令牌
                tokenStore.removeAccessToken(oAuth2AccessToken);
            }
        }

        // 退出成功，响应结果
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(Result.ok()) );
    }
}
