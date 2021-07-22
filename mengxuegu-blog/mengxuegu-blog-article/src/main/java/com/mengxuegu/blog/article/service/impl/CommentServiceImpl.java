package com.mengxuegu.blog.article.service.impl;

import com.mengxuegu.blog.entities.Comment;
import com.mengxuegu.blog.article.mapper.CommentMapper;
import com.mengxuegu.blog.article.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengxuegu.blog.util.base.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论信息表 服务实现类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-22
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {


    @Override
    public Result findByArticleId(String articleId) {
        if(StringUtils.isBlank(articleId)){
            return Result.error("文章ID不能为空");
        }
        return Result.ok(baseMapper.findByArticleId(articleId));
    }
}
