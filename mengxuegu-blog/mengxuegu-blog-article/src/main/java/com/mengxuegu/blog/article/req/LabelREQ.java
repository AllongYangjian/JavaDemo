package com.mengxuegu.blog.article.req;

import com.mengxuegu.blog.entities.Label;
import com.mengxuegu.blog.util.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: LabelREQ
 * Author:   yangjian
 * Date:     2021/7/20 22:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/20 22:45        1.0              描述
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "LabelREQ对象",description = "标签的查询条件")
@Accessors(chain = true)
public class LabelREQ extends BaseRequest<Label> {

    @ApiModelProperty(value = "标签名称")
    private String name;

    @ApiModelProperty("分类ID")
    private String categoryId;

}
