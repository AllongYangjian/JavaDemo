package com.yj.jpa.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    private Date birthday;

    private Date createTime;

    private Set<Items> items = new HashSet<>();

    private Set<Category> categories = new HashSet<>();

    public Customer(String lastName, int age) {
        this.lastName = lastName;
        this.age = age;
    }

    public Customer() {
    }

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

    @Temporal(TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @OneToMany(cascade = {CascadeType.REMOVE}) //设置级联删除
    @JoinColumn(name = "customer_id")
    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }

    @OneToMany(mappedBy = "customer")//指定由多的一方维护关联关系
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", createTime=" + createTime +
                ", items=" + items +
                '}';
    }
}
