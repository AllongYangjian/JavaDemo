package com.yj.hibernate.n21;

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
public class Customer {

    private Integer id;

    private String name;

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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
