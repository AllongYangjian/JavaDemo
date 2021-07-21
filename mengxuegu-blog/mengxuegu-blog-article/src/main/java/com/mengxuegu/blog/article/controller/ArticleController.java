package com.mengxuegu.blog.article.controller;


import com.mengxuegu.blog.article.req.ArticleREQ;
import com.mengxuegu.blog.article.req.ArticleUserREQ;
import com.mengxuegu.blog.article.service.IArticleService;
import com.mengxuegu.blog.entities.Article;
import com.mengxuegu.blog.util.base.Result;
import com.mengxuegu.blog.util.enums.ArticleStatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

    @ApiOperation("查询文章详情接口")
    @ApiImplicitParam(name = "id", value = "文章ID", required = true)
    @GetMapping("/{id}")
    public Result findArticleAndLabelById(@PathVariable String id) {
        return articleService.findArticleAndLabelById(id);
    }

    @ApiOperation("修改文章信息接口")
    @PutMapping
    public Result update(@RequestBody Article article) {
        return articleService.updateOrSave(article);
    }

    @ApiOperation("新增文章信息接口")
    @PostMapping
    public Result save(@RequestBody Article article) {
        return articleService.updateOrSave(article);
    }

    @ApiOperation("删除文章接口")
    @ApiImplicitParam(name = "id", value = "文章ID", required = true)
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        return articleService.updateStatus(id, ArticleStatusEnum.DELETE);
    }

    @ApiOperation("审核通过接口")
    @ApiImplicitParam(name = "id", value = "文章ID", required = true)
    @GetMapping("/audit/success/{id}")
    public Result success(@PathVariable String id) {
        return articleService.updateStatus(id, ArticleStatusEnum.SUCCESS);
    }

    @ApiOperation("审核不通过接口")
    @ApiImplicitParam(name = "id", value = "文章ID", required = true)
    @GetMapping("/audit/fail/{id}")
    public Result fail(@PathVariable String id) {
        return articleService.updateStatus(id, ArticleStatusEnum.FAIL);
    }

    @ApiOperation("根据用户id查询公开或未公开的文章列表")
    @PostMapping("/user")
    public Result findListByUserIdAndIsPublic(@RequestBody ArticleUserREQ req) {
        return articleService.findListByUserIdAndIsPublic(req);
    }

    @ApiOperation("更新文章点赞数")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "文章id", required = true),
            @ApiImplicitParam(name = "count", value = "点赞数", required = true)})
    @PutMapping("/thumb/{id}/{count}")
    public Result updateArticleThumb(@PathVariable String id, @PathVariable int count) {
        return articleService.updateArticleThumb(id, count);
    }


}
