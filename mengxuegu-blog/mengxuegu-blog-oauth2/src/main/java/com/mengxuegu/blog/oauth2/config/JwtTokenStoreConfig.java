package com.mengxuegu.blog.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

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
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        KeyStoreKeyFactory factory = new KeyStoreKeyFactory(new ClassPathResource("allong.jks"), "allong".toCharArray());
        KeyPair keyPair = factory.getKeyPair("allong");
        tokenConverter.setKeyPair(keyPair);
        return tokenConverter;
    }

    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

}
