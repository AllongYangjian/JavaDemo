package com.yj.hibernate.n212n;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Customer
 * Author:   yangjian
 * Date:     2020/11/11 20:46
 * Description: 顾客
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/11 20:46        1.0              描述
 */
public class Customer1 {

    private Integer id;

    private String name;

    private Set<Order1> orders = new HashSet<>();

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

    public Set<Order1> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order1> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
