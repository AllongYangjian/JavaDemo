package com.allong.yj.springdata.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Person
 * Author:   yangjian
 * Date:     2020/11/15 0:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/15 0:16        1.0              描述
 */
@Entity
@Table(name = "person")
public class Person {

    private Integer id;

    private String lastName;

    private String email;

    private Date birth;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Temporal(TemporalType.DATE)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}
