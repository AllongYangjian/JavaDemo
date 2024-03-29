package com.mengxuegu.blog.question.controller;


import com.mengxuegu.blog.entities.Question;
import com.mengxuegu.blog.question.req.QuestionUserREQ;
import com.mengxuegu.blog.question.service.IQuestionService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 问题信息表 前端控制器
 * </p>
 *
 * @author yangjian
 * @since 2021-07-25
 */
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @ApiOperation("修改问题信息接口")
    @PutMapping // put 方式请求 /question/question
    public Result update(@RequestBody Question question) {
        return questionService.updateOrSave(question);
    }

    @ApiOperation("新增问题信息接口")
    @PostMapping // post 请求 /question/question
    public Result save(@RequestBody Question question) {
        return questionService.updateOrSave(question);
    }

    @ApiOperation("删除问题信息接口")
    @ApiImplicitParam(name = "id", value = "问题ID", required = true)
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id) {
        return questionService.deleteById(id);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "问题ID", required = true),
            @ApiImplicitParam(name = "count", value = "点赞数(只能是1或-1)", required = true)
    })
    @ApiOperation("更新点赞数")
    @PutMapping("/thumb/{id}/{count}")
    public Result updateThumhup(@PathVariable("id") String id,
                                @PathVariable("count") int count) {
        return questionService.updateThumhup(id, count);
    }


    @ApiOperation("根据用户id查询问题列表")
    @PostMapping("/user")
    public Result findListByUserId(@RequestBody QuestionUserREQ req) {
        return questionService.findListByUserId(req);
    }


}
