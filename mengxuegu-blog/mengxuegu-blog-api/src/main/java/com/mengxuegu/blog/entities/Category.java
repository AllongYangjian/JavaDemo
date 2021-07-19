package com.mengxuegu.blog.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: Category
 * Author:   yangjian
 * Date:     2021/7/19 21:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/19 21:49        1.0              描述
 */
@Data
@TableName("mxg_category")
public class Category implements Serializable {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 分类名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态(1:正常，0：禁用)
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 更新日期
     */
    private Date updateDate;

}
