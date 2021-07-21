package com.mengxuegu.blog.article.controller;


import com.mengxuegu.blog.article.req.ArticleREQ;
import com.mengxuegu.blog.article.service.IArticleService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文章信息表 前端控制器
 * </p>
 *
 * @author yangjian
 * @since 2021-07-21
 */
@RestController
@RequestMapping("/article")
@Api(value = "文章管理接口", description = "提供文章信息的增删改查")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @ApiOperation("根据文章标题和状态查询文分页列表接口")
    @PostMapping("/search")
    public Result search(@RequestBody ArticleREQ req) {
        return articleService.queryPage(req);
    }

    @ApiOperation("查询文件详情接口")
    @ApiImplicitParam(name = "id",value = "文章ID",required = true)
    @GetMapping("/{id}")
    public Result findArticleAndLabelById(@PathVariable String id){
        return articleService.findArticleAndLabelById(id);
    }

}
