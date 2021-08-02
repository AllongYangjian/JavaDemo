package com.mengxuegu.blog.web.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.common.HttpHeader;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.mengxuegu.blog.util.base.Result;
import com.mengxuegu.blog.util.enums.ResultEnum;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: AuthService
 * Author:   yangjian
 * Date:     2021/7/31 15:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/31 15:41        1.0              描述
 */
@Service
public class AuthService {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 通过刷新令牌获取新的token信息
     * @param header
     * @param refreshToken
     * @return
     */
    public Result refreshToken(String header,String refreshToken) throws HttpProcessException {
        //采用客户端负载均衡
        ServiceInstance choose = loadBalancerClient.choose("auth-server");
        if(choose ==null){
            return  Result.error("未找到有效资源服务器");
        }
        String refreshTokenUrl = choose.getUri().toString()+"/auth/oauth/token";
        Map<String,Object> map = new HashMap<>();
        map.put("grant_type","refresh_token");
        map.put("refresh_token",refreshToken);
        Header[] headers = HttpHeader.custom().contentType(HttpHeader.Headers.APP_FORM_URLENCODED)
                .authorization(header)
                .build();
        HttpConfig httpConfig = HttpConfig.custom().headers(headers).url(refreshTokenUrl).map(map);
        String result = HttpClientUtil.post(httpConfig);
        JSONObject jsonObject = JSON.parseObject(result);
        //获取token失败
        if(StringUtils.isNotEmpty(jsonObject.getString("error"))){
            return Result.build(ResultEnum.TOKEN_PAST);
        }
        return Result.ok(jsonObject);

    }
}
