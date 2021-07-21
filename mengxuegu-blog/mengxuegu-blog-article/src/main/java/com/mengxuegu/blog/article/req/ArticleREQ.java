package com.mengxuegu.blog.article.req;

import com.mengxuegu.blog.entities.Article;
import com.mengxuegu.blog.util.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ArticleReq
 * Author:   yangjian
 * Date:     2021/7/21 21:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/21 21:22        1.0              描述
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ArticleREQ对象",description = "文章查询条件")
public class ArticleREQ extends BaseRequest<Article> {
    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty("0: 已删除, 1:未审核，2:审核通过，3：审核未通过")
    private Integer status;
}
