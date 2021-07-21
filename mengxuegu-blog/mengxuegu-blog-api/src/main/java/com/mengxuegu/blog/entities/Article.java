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
 * 文章信息表
 * </p>
 *
 * @author yangjian
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("mxg_article")
@ApiModel(value="Article对象", description="文章信息表")
public class Article implements Serializable {

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

    @ApiModelProperty(value = "文章标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "文章简介")
    @TableField("summary")
    private String summary;

    @ApiModelProperty(value = "文章主图地址")
    @TableField("image_url")
    private String imageUrl;

    @ApiModelProperty(value = "md主体内容")
    @TableField("md_content")
    private String mdContent;

    @ApiModelProperty(value = "html主体内容")
    @TableField("html_content")
    private String htmlContent;

    @ApiModelProperty(value = "浏览次数")
    @TableField("view_count")
    private Integer viewCount;

    @ApiModelProperty(value = "点赞数")
    @TableField("thumhup")
    private Integer thumhup;

    @ApiModelProperty(value = "0: 已删除, 1:未审核，2:审核通过，3：审核未通过")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "0：不公开，1：公开")
    @TableField("ispublic")
    private Integer ispublic;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_date")
    private Date createDate;

    @ApiModelProperty(value = "更新时间")
    @TableField("update_date")
    private Date updateDate;

    @ApiModelProperty("所属标签对象集合")
    @TableField(exist = false)
    private List<Label> labelList;


    @ApiModelProperty("所属标签ID集合")
    @TableField(exist = false)
    private List<String> labelIds;
}
