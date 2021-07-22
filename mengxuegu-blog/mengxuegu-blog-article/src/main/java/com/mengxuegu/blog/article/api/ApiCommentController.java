package com.mengxuegu.blog.article.api;

import com.mengxuegu.blog.article.req.ArticleListREQ;
import com.mengxuegu.blog.article.service.IArticleService;
import com.mengxuegu.blog.article.service.ICommentService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ApiCategoryController
 * Author:   yangjian
 * Date:     2021/7/20 23:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/20 23:41        1.0              描述
 */
@Api(value = "评论管理接口", description = "不需要通过身份认证就能访问的评论信息接口")
@RestController
@RequestMapping("/api/comment")
public class ApiCommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/list/{articleId}")
    @ApiOperation("根据文章id查询评论列表")
    @ApiImplicitParam(name = "articleId", value = "文章id", required = true)
    public Result list(@PathVariable String articleId) {
        return commentService.findByArticleId(articleId);
    }
}
