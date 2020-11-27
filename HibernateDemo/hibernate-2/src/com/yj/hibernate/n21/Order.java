package com.yj.hibernate.n21;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Order
 * Author:   yangjian
 * Date:     2020/11/11 21:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/11 21:12        1.0              描述
 */
public class Order {

    private Integer id;

    private String name;

    private Customer customer;

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
