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
 * 评论信息表
 * </p>
 *
 * @author yangjian
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("mxg_comment")
@ApiModel(value = "Comment对象", description = "评论信息表")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "-1表示正常回复，其他值表示是评论的回复")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty(value = "评论者用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "评论者用户昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty(value = "评论者头像url")
    @TableField("user_image")
    private String userImage;

    @ApiModelProperty(value = "文章id")
    @TableField("article_id")
    private String articleId;

    @ApiModelProperty(value = "评论内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_date")
    private Date createDate;

    @ApiModelProperty("子评论集合")
    @TableField(exist = false)
    private List<Comment> children;


}
