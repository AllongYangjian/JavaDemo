package com.mengxuegu.blog.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 问题信息表
 * </p>
 *
 * @author yangjian
 * @since 2021-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("mxg_question")
@ApiModel(value = "Question对象", description = "问题信息表")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "发布者用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "发布者用户昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty(value = "发布者头像url")
    @TableField("user_image")
    private String userImage;

    @ApiModelProperty(value = "问题标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "md问题内容")
    @TableField("md_content")
    private String mdContent;

    @ApiModelProperty(value = "html问题内容")
    @TableField("html_content")
    private String htmlContent;

    @ApiModelProperty(value = "浏览次数")
    @TableField("view_count")
    private Integer viewCount;

    @ApiModelProperty(value = "点赞数")
    @TableField("thumhup")
    private Integer thumhup;

    @ApiModelProperty(value = "回复数")
    @TableField("reply")
    private Integer reply;

    @ApiModelProperty(value = "状态，0：已删除， 1：未解决，2：已解决")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_date")
    private Date createDate;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_date")
    private Date updateDate;

    @ApiModelProperty(value = "标签ID列表")
    @TableField(exist = false)
    private List<String> labelIds;

    @ApiModelProperty(value = "标签对象集合")
    @TableField(exist = false)
    private List<Label> labelList;
}
