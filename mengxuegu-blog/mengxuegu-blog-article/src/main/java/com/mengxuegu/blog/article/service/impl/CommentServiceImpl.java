package com.mengxuegu.blog.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mengxuegu.blog.entities.Comment;
import com.mengxuegu.blog.article.mapper.CommentMapper;
import com.mengxuegu.blog.article.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengxuegu.blog.util.base.Result;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        if (StringUtils.isBlank(articleId)) {
            return Result.error("文章ID不能为空");
        }
        return Result.ok(baseMapper.findByArticleId(articleId));
    }

    @Override
    public Result deleteById(String id) {
        if (StringUtils.isEmpty(id)) {
            return Result.error("评论id不能为空");
        }
        List<String> idList = new ArrayList<>();
        idList.add(id);
        this.getIds(idList, id);
        return Result.ok(baseMapper.deleteBatchIds(idList));
    }

    /**
     * 递归所有的评论id
     * @param ids
     * @param parentId
     */
    private void getIds(List<String> ids, String parentId) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", parentId);
        List<Comment> commentList = baseMapper.selectList(wrapper);
        if (CollectionUtils.isNotEmpty(commentList)) {
            for (Comment comment : commentList) {
                String id = comment.getId();
                ids.add(id);
                this.getIds(ids, id);
            }
        }
    }
}
