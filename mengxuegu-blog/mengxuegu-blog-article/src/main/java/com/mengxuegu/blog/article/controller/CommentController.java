package com.mengxuegu.blog.article.controller;


import com.mengxuegu.blog.article.service.ICommentService;
import com.mengxuegu.blog.entities.Comment;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}")
    @ApiOperation("递归删除评论")
    @ApiImplicitParam(name = "id", value = "评论id", required = true)
    public Result delete(@PathVariable String id) {
        return commentService.deleteById(id);
    }

    @ApiOperation("新增评论信息接口")
    @PostMapping
    public Result save(@RequestBody Comment comment) {
        return Result.ok(commentService.save(comment));
    }

}
