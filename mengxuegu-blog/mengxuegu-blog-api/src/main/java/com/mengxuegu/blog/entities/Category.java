package com.mengxuegu.blog.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@ApiModel(value = "文章分类对象", description = "类别信息表")
public class Category implements Serializable {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private String id;
    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String name;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 状态(1:正常，0：禁用)
     */
    @ApiModelProperty(value = "状态(1:正常，0：禁用)")
    private Integer status;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 创建日期
     */
    @ApiModelProperty(value = "创建日期")
    private Date createDate;
    /**
     * 更新日期
     */
    @ApiModelProperty(value = "更新日期")
    private Date updateDate;

    @ApiModelProperty(value = "分类标签信息集合")
    @TableField(exist = false)
    private List<Label> labelList;

}
