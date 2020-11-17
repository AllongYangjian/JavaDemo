package com.yj.mybatis.domain;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Employee
 * Author:   yangjian
 * Date:     2020/11/17 21:30
 * Description: 员工类
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/17 21:30        1.0              描述
 */
public class Employee {

    private Integer id;

    private String name;

    private Integer age;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
