package com.mengxuegu.blog.oauth2.config;

import com.alibaba.fastjson.JSON;
import com.mengxuegu.blog.oauth2.service.JwtUser;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: JwtTokenEnhancer
 * Author:   yangjian
 * Date:     2021/7/30 0:15
 * Description: token信息增强
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/30 0:15        1.0              描述
 */
@Component
public class JwtTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        JwtUser user = (JwtUser) oAuth2Authentication.getPrincipal();
        Map<String,Object> map = new HashMap<>();
        map.put("userInfo", JSON.toJSON(user));

        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(map);

        return oAuth2AccessToken;
    }
}
