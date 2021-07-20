package com.mengxuegu.blog.article.req;

import com.mengxuegu.blog.entities.Category;
import com.mengxuegu.blog.util.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: CategoryREQ
 * Author:   yangjian
 * Date:     2021/7/19 22:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/19 22:40        1.0              描述
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "条件对象",description = "查询条件")
public class CategoryREQ extends BaseRequest<Category> {
    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String name;

    /**
     * 状态 (1:启用 0:禁用)
     */
    @ApiModelProperty(value = "状态 (1:启用 0:禁用)")
    private String status;
}
