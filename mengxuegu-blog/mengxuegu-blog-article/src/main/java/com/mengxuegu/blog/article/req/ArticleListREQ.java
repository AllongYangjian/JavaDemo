package com.mengxuegu.blog.article.req;

import com.mengxuegu.blog.entities.Article;
import com.mengxuegu.blog.util.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ArticleListREQ
 * Author:   yangjian
 * Date:     2021/7/21 23:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/21 23:10        1.0              描述
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "文章列表查询对象",description = "根据分类id，标签id查询条件")
public class ArticleListREQ extends BaseRequest<Article> {

    @ApiModelProperty("标签ID")
    private String labelId;

    @ApiModelProperty("分类ID")
    private String categoryId;

}
