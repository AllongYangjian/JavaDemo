package com.mengxuegu.blog.question.controller;


import com.mengxuegu.blog.entities.Question;
import com.mengxuegu.blog.question.service.IQuestionService;
import com.mengxuegu.blog.util.base.Result;
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

}
