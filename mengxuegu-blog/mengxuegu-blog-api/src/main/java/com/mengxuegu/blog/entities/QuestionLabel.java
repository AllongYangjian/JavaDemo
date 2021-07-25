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
 * 问题标签中间表
 * </p>
 *
 * @author yangjian
 * @since 2021-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("mxg_question_label")
@ApiModel(value="QuestionLabel对象", description="问题标签中间表")
public class QuestionLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "文章 id")
    @TableField("question_id")
    private String questionId;

    @ApiModelProperty(value = "标签id")
    @TableField("label_id")
    private String labelId;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_date")
    private Date createDate;


}
