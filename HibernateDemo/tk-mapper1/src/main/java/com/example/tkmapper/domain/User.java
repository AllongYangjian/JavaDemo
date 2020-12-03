package com.example.tkmapper.domain;

import com.example.tkmapper.typehandler.AddressTypeHandler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.ColumnType;

import java.io.Serializable;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: User
 * Author:   yangjian
 * Date:     2020/12/3 22:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/12/3 22:32        1.0              描述
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Integer id;

    private String name;

    private Integer age;
    /**
     * 自定义类型转换器
     */
    @ColumnType(typeHandler = AddressTypeHandler.class)
    private Address address;

    private EnumStatus status;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", status=" + status.getValue() +
                '}';
    }
}
