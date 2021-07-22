package com.mengxuegu.blog.article.controller;


import com.mengxuegu.blog.article.service.ICommentService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 评论信息表 前端控制器
 * </p>
 *
 * @author yangjian
 * @since 2021-07-22
 */
@RestController
@RequestMapping("/comment")
@Api(value = "文章评论信息接口", description = "评论信息的增删改查")
public class CommentController {

    @Autowired
    private ICommentService commentService;


    @GetMapping("/{articleId}")
    @ApiOperation("根据文章id查询评论列表")
    @ApiImplicitParam(name = "articleId", value = "文章id", required = true)
    public Result list(@PathVariable String articleId) {
        return commentService.findByArticleId(articleId);
    }

}
