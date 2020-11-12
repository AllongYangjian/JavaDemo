package com.yj.jpa.domain;

import javax.persistence.*;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Customer
 * Author:   yangjian
 * Date:     2020/11/12 23:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/12 23:39        1.0              描述
 */
@Entity
@Table(name = "customer")
public class Customer {

    private Integer id;

    private String lastName;

    private String email;

    private int age;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
