package com.yj.hibernate.foreign;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Department
 * Author:   yangjian
 * Date:     2020/11/11 22:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/11 22:32        1.0              描述
 */
public class Department {

    private Integer id;


    private String name;

    private Manager mgr;

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


    public Manager getMgr() {
        return mgr;
    }

    public void setMgr(Manager mgr) {
        this.mgr = mgr;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
