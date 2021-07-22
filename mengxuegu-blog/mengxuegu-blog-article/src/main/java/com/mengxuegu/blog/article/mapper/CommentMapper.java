package com.mengxuegu.blog.article.mapper;

import com.mengxuegu.blog.entities.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 评论信息表 Mapper 接口
 * </p>
 *
 * @author yangjian
 * @since 2021-07-22
 */
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> findByArticleId(@Param("articleId")String articleId);
}
