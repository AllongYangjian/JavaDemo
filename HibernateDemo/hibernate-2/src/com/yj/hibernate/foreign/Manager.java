package com.yj.hibernate.foreign;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Manager
 * Author:   yangjian
 * Date:     2020/11/11 22:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/11 22:32        1.0              描述
 */
public class Manager {

    private Integer id;

    private String name;

    private Department dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
