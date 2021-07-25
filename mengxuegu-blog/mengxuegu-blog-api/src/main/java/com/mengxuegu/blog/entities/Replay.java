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
 * 回答信息表
 * </p>
 *
 * @author yangjian
 * @since 2021-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("mxg_replay")
@ApiModel(value="Replay对象", description="回答信息表")
public class Replay implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "-1 表示正常回答，其他值表示是回答的回复")
    @TableField("parent_id")
    private String parentId;

    @ApiModelProperty(value = "回答者id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "回答者用户昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty(value = "回答者头像url")
    @TableField("user_image")
    private String userImage;

    @ApiModelProperty(value = "问题id")
    @TableField("question_id")
    private String questionId;

    @ApiModelProperty(value = "md问题内容")
    @TableField("md_content")
    private String mdContent;

    @ApiModelProperty(value = "html问题内容")
    @TableField("html_content")
    private String htmlContent;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_date")
    private Date createDate;


}
