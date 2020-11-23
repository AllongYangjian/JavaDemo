package com.allong.mybatis3.domain;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Department
 * Author:   yangjian
 * Date:     2020/11/23 22:59
 * Description: 科室
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/23 22:59        1.0              描述
 */
public class Department {

    private Integer id;

    private String name;

    private String desc;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
