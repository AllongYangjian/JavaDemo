package com.example.mybatisplus1.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
public class Employee extends Model<Employee>  {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String lastName;

    private String email;

    private Integer gender;

    private Integer age;

    @Override
    protected Serializable pkVal() {
        return id;
    }

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
