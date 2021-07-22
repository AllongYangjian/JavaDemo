package com.mengxuegu.blog.article.service;

import com.mengxuegu.blog.entities.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.util.base.Result;

/**
 * <p>
 * 评论信息表 服务类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-22
 */
public interface ICommentService extends IService<Comment> {
    /**
     * 根据文章id查询评论列表
     * @param articleId
     * @return
     */
    Result findByArticleId(String articleId);
}
