package com.mengxuegu.blog.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: JwtTokenStoreConfig
 * Author:   yangjian
 * Date:     2021/7/29 23:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/29 23:33        1.0              描述
 */
@Configuration
public class JwtTokenStoreConfig {

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter =
                new JwtAccessTokenConverter();
        // 采用非对称加密文件
        KeyStoreKeyFactory factory = new KeyStoreKeyFactory(
                new ClassPathResource("oauth2.jks"), "oauth2".toCharArray());
        converter.setKeyPair( factory.getKeyPair("oauth2") );

        return converter;
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter()){
            @Override
            public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
                Map<String, Object> additionalInformation = token.getAdditionalInformation();
                if(additionalInformation.containsKey("jti")){
                    String jti = additionalInformation.get("jti").toString();
                    redisTemplate.opsForValue().set(jti,token.getValue(),token.getExpiresIn(), TimeUnit.SECONDS);
                }
            }

            @Override
            public void removeAccessToken(OAuth2AccessToken token) {
                Map<String, Object> additionalInformation = token.getAdditionalInformation();
                if(additionalInformation.containsKey("jti")){
                    String jti = additionalInformation.get("jti").toString();
                    redisTemplate.delete(jti);
                }
            }
        };
    }

}
