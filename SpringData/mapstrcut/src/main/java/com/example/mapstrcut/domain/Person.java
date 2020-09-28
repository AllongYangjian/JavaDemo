package com.example.mapstrcut.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Person
 * Author:   YJ
 * Date:     2020/9/28 13:23
 * Description: 用户信息
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/28 13:23        1.0              描述
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private Long id;

    private String name;

    private String email;

    private Date birthday;

    private Boolean enable;

    private User user;
}
