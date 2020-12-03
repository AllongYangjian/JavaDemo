package com.example.tkmapper.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Address
 * Author:   yangjian
 * Date:     2020/12/3 22:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/12/3 22:32        1.0              描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    private String national;

    private String province;

    private String city;
}
