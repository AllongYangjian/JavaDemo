package com.mengxuegu.blog.article.mapper;

import com.mengxuegu.blog.entities.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 文章信息表 Mapper 接口
 * </p>
 *
 * @author yangjian
 * @since 2021-07-21
 */
public interface ArticleMapper extends BaseMapper<Article> {

    Article findArticleAndLabelById(String id);
}
