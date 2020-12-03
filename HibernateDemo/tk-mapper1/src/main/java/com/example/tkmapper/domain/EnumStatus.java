package com.example.tkmapper.domain;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: EnumStatus
 * Author:   yangjian
 * Date:     2020/12/3 23:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/12/3 23:01        1.0              描述
 */
public enum EnumStatus {
    Spring("春"),
    Summer("夏"),
    Autumn("秋"),
    Winter("东");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    EnumStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EnumStatus{" +
                "value='" + value + '\'' +
                '}';
    }
}
