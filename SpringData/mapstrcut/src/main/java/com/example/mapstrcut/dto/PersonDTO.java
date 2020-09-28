package com.example.mapstrcut.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: PersonDTO
 * Author:   YJ
 * Date:     2020/9/28 13:25
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/28 13:25        1.0              描述
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDTO {
    private Long id;

    private String name;

    private Integer age;

    private String email;

    private Date birthday;

    private String enable;

    private String birthDateFormat;

    private String birthExpressionFormat;


}
