package com.yj.jpa.domain;

import javax.persistence.*;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Items
 * Author:   yangjian
 * Date:     2020/11/14 18:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/14 18:20        1.0              描述
 */
@Entity
@Table(name = "items")
public class Items {

    private Integer id;

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
