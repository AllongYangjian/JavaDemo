package com.yj.springsecuritydemo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: EncodingTest
 * Author:   yangjian
 * Date:     2020/10/13 23:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/10/13 23:20        1.0              描述
 */
public class EncodingTest {

    //    $2a$10$NIoK7.vJTqrnBoxSxpqPPeixjluoYK2LupxNE98JVVLVlwGeN2GQS
//    $2a$10$FaYb3m99J7hRk78Pgw67O.oI7iIeDajyunYyKiElOdo/3YvXcY5RO
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.err.println(encoder.encode("123"));
    }
}
