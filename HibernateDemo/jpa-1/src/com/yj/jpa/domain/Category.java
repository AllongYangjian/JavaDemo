package com.yj.jpa.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Category
 * Author:   yangjian
 * Date:     2020/11/14 18:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/14 18:54        1.0              描述
 */
@Entity
@Table(name = "jpa_category")
public class Category {

    private Integer id;

    private String name;

    private Customer customer;

    private Set<Items> items = new HashSet<>();

    @Id
    @GeneratedValue
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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToMany(mappedBy = "categories")
    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }
}
