package com.mengxuegu.blog.article.api;

import com.mengxuegu.blog.article.req.ArticleListREQ;
import com.mengxuegu.blog.article.service.IArticleService;
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
@Api(value = "文章管理接口", description = "不需要通过身份认证就能访问")
@RestController
@RequestMapping("/api/article")
public class ApiArticleController {

    @Autowired
    private IArticleService articleService;

    @ApiOperation("查询文件详情接口")
    @ApiImplicitParam(name = "id", value = "文章ID", required = true)
    @GetMapping("/{id}")
    public Result findArticleAndLabelById(@PathVariable String id) {
        return articleService.findArticleAndLabelById(id);
    }

    @ApiOperation("更新文章浏览次数")
    @ApiImplicitParam(name = "id", value = "文章ID", required = true)
    @PutMapping("/{id}")
    public Result updateViewCount(@PathVariable String id) {
        return articleService.updateViewCount(id);
    }


    @ApiOperation("查询公开且已审核的文章列表")
    @PostMapping("/list")
    public Result findListByLabelIdOrCategoryId(@RequestBody ArticleListREQ req) {
        return articleService.findListByLabelIdOrCategoryId(req);
    }
}
