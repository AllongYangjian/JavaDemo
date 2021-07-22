package com.mengxuegu.blog.article.service.impl;

import com.mengxuegu.blog.entities.Comment;
import com.mengxuegu.blog.article.mapper.CommentMapper;
import com.mengxuegu.blog.article.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
