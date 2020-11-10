package com.yj.hibernate.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Address
 * Author:   yangjian
 * Date:     2020/11/8 10:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/8 10:58        1.0              描述
 */
@Entity
public class Address {
    private int id;
    private String address;
    private String remark;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return id == address1.id &&
                Objects.equals(address, address1.address) &&
                Objects.equals(remark, address1.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, remark);
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
