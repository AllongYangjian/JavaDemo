package com.mengxuegu.blog.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: RequestUtil
 * Author:   yangjian
 * Date:     2021/7/15 23:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/15 23:54        1.0              描述
 */
public class RequestUtil {

    public static String[] extractAndDecodeHeader(String header) throws IOException {
        //Basic 后面开始截取 clientId:clientSecret
        byte[] base64Token = header.trim().substring(6).getBytes(StandardCharsets.UTF_8);
        byte[] decoded;
        try {
            decoded = Base64.getDecoder().decode(base64Token);
        } catch (IllegalStateException e) {
            throw new RuntimeException("请求头解析失败:" + header);
        }
        String token = new String(decoded, StandardCharsets.UTF_8);
        int delim = token.indexOf(":");
        if (delim == -1) {
            throw new RuntimeException("请求头无效:" + token);
        } else {
            return new String[]{token.substring(0, delim), token.substring(delim + 1)};
        }
    }
}
