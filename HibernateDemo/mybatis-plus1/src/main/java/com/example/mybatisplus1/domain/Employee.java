package com.example.mybatisplus1.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Employee
 * Author:   yangjian
 * Date:     2020/12/6 13:51
 * Description: 员工
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/12/6 13:51        1.0              描述
 */
@Getter
@Setter
public class Employee {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String lastName;

    private String email;

    private Integer gender;

    private Integer age;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
