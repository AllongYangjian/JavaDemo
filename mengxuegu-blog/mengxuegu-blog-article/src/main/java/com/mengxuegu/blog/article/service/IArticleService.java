package com.mengxuegu.blog.article.service;

import com.mengxuegu.blog.article.req.ArticleREQ;
import com.mengxuegu.blog.entities.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.util.base.Result;

/**
 * <p>
 * 文章信息表 服务类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-21
 */
public interface IArticleService extends IService<Article> {

    /**
     * 条件分页查询文章列表
     *
     * @param req
     * @return
     */
    Result queryPage(ArticleREQ req);

    /**
     * 查询文章详情接口
     *
     * @param id
     * @return
     */
    Result findArticleAndLabelById(String id);
}
