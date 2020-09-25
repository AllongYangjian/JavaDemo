package com.allong.bean;

import lombok.Builder;
import lombok.Data;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Student
 * Author:   YJ
 * Date:     2020/9/25 13:21
 * Description: 学生类
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/25 13:21        1.0              描述
 */
@Data
public class Student {

    private String name;

    private int age;

    private int score;

    private String number;

}
