package com.example.springsecurityjwt.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: RsaProperties
 * Author:   YJ
 * Date:     2020/11/30 10:02
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/11/30 10:02        1.0              描述
 */
@Configuration
@ConfigurationProperties(prefix = "rsa")
@Getter
@Setter
public class RsaProperties {

    private String publicKeyText;
    private String privateKeyText;

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @PostConstruct
    public void createRsaKey() throws Exception {
        publicKey = RsaUtils.getPublicKey(publicKeyText);
        privateKey = RsaUtils.getPrivateKey(privateKeyText);
    }
}
