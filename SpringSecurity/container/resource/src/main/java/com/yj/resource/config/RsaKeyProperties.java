package com.yj.resource.config;

import com.yj.common.utils.RsaUtils;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: RsaKeyProperties
 * Author:   yangjian
 * Date:     2020/10/28 0:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/28 0:45        1.0              描述
 */
@ConfigurationProperties("rsa.key")
@Getter
@Setter
public class RsaKeyProperties {


    private String pubKeyFile;


    private PublicKey publicKey;


    @PostConstruct
    public void crateRsaKey() throws Exception {
        publicKey = RsaUtils.getPublicKey(pubKeyFile);
    }
}
