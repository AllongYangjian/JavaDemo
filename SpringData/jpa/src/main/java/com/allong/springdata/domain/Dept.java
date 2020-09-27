package com.allong.springdata.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Dept
 * Author:   YJ
 * Date:     2020/9/25 15:24
 * Description: 科室
 * History:
 * <author>          <time>          <version>          <desc>
 * YJ       2020/9/25 15:24        1.0              描述
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "sys_dept")
public class Dept {

    @Id
    @Column(name = "dept_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
