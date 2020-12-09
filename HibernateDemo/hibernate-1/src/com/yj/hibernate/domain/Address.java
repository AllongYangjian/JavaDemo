package com.yj.hibernate.domain;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Address
 * Author:   yangjian
 * Date:     2020/11/7 23:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/7 23:05        1.0              描述
 */
public class Address {

    private Integer id;

    private String address;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Address(Integer id, String address, String remark) {
        this.id = id;
        this.address = address;
        this.remark = remark;
    }

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
