package com.yj.hibernate.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: EdrBaseReqlog
 * Author:   yangjian
 * Date:     2020/11/12 21:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/12 21:15        1.0              描述
 */
@Entity
@Table(name = "edr_base_reqlog", schema = "edrtest")
public class EdrBaseReqlog {

    public EdrBaseReqlog() {
    }

    public EdrBaseReqlog(String loginname, String reqUrl) {
        this.loginname = loginname;
        this.reqUrl = reqUrl;
    }

    private int id;
    private String loginname;
    private String reqUrl;
    private Timestamp reqtime;
    private String reqparam;
    private String resparam;
    private Timestamp createtime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "loginname")
    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    @Basic
    @Column(name = "reqUrl")
    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    @Basic
    @Column(name = "reqtime")
    public Timestamp getReqtime() {
        return reqtime;
    }

    public void setReqtime(Timestamp reqtime) {
        this.reqtime = reqtime;
    }

    @Basic
    @Column(name = "reqparam")
    public String getReqparam() {
        return reqparam;
    }

    public void setReqparam(String reqparam) {
        this.reqparam = reqparam;
    }

    @Basic
    @Column(name = "resparam")
    public String getResparam() {
        return resparam;
    }

    public void setResparam(String resparam) {
        this.resparam = resparam;
    }

    @Basic
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EdrBaseReqlog that = (EdrBaseReqlog) o;
        return id == that.id &&
                Objects.equals(loginname, that.loginname) &&
                Objects.equals(reqUrl, that.reqUrl) &&
                Objects.equals(reqtime, that.reqtime) &&
                Objects.equals(reqparam, that.reqparam) &&
                Objects.equals(resparam, that.resparam) &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loginname, reqUrl, reqtime, reqparam, resparam, createtime);
    }

    @Override
    public String toString() {
        return "EdrBaseReqlog{" +
                "id=" + id +
                '}';
    }
}
