package com.mengxuegu.blog.article.req;

import com.mengxuegu.blog.entities.Article;
import com.mengxuegu.blog.util.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ArticleUserREQ
 * Author:   yangjian
 * Date:     2021/7/21 22:45
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/21 22:45        1.0              描述
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ArticleUserREQ对象",description = "用户ID和是否公开查询条件类")
public class ArticleUserREQ extends BaseRequest<Article> {

    @ApiModelProperty(value = "用户ID",required = true)
    private String userId;

    @ApiModelProperty(value = "是否公开",required = true)
    private Integer isPublic;
}
