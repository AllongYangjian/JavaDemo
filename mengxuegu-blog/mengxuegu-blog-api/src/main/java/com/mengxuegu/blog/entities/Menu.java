package com.mengxuegu.blog.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单信息表
 * </p>
 *
 * @author yangjian
 * @since 2021-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_menu")
@ApiModel(value="Menu对象", description="菜单信息表")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单 ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "父菜单 ID (0为顶级菜单)")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty(value = "菜单名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "请求地址")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "类型(1目录，2菜单，3按钮)")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "授权标识符")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_date")
    private Date createDate;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_date")
    private Date updateDate;


}
