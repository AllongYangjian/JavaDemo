package com.jiancode.springmvc.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Description：TODO
 * author：yj
 * email：yj@allong.net
 * date：2019-06-26 11:30
 * version：1.0
 */
@XmlRootElement
public class Student {

    private int id;

    private String name;

    private int score;

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    @XmlElement
    public void setScore(int score) {
        this.score = score;
    }
}
