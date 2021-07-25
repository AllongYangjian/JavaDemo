package com.mengxuegu.blog.question.api;

import com.mengxuegu.blog.entities.Question;
import com.mengxuegu.blog.question.service.IQuestionService;
import com.mengxuegu.blog.util.base.BaseRequest;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ApiQuestionController
 * Author:   yangjian
 * Date:     2021/7/25 15:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/25 15:29        1.0              描述
 */
@RequestMapping("/api/question")
@RestController
@Api(value = "问答管理接口", description = "问答管理接口，不同通过身份认证即可调用接口")
public class ApiQuestionController {

    @Autowired
    private IQuestionService questionService;

    @ApiOperation("查询热门问答列表")
    @PostMapping("/hot")
    public Result search(@RequestBody BaseRequest<Question> req) {
        return questionService.findHotList(req);
    }


    @ApiOperation("查询最新问答列表")
    @PostMapping("/new")
    public Result newList(@RequestBody BaseRequest<Question> req) {
        return questionService.findNewList(req);
    }

    @ApiOperation("查询等待应答列表")
    @PostMapping("/wait")
    public Result waitList(@RequestBody BaseRequest<Question> req) {
        return questionService.findWaitList(req);
    }


    @ApiOperation("根据标签id分页查询问题列表")
    @ApiImplicitParam(name = "labelId",value = "标签ID",required = true)
    @PostMapping("/list/{labelId}")
    public Result labelList(@RequestBody BaseRequest<Question> req, @PathVariable("labelId")String labelId) {
        return questionService.findLabelQuestionList(req,labelId);
    }


    @ApiOperation("查询问题详情接口")
    @ApiImplicitParam(name="id", value="问题ID", required=true)
    @GetMapping("/{id}")
    public Result view(@PathVariable("id") String id) {
        return questionService.findById(id);
    }

    @ApiOperation("更新浏览数接口")
    @ApiImplicitParam(name="id", value="问题ID", required=true)
    @PutMapping("/viewCount/{id}")
    public Result updateViewCount(@PathVariable("id") String id) {
        return questionService.updateViewCount(id);
    }

    @ApiOperation("查询提问总记录")
    @GetMapping("/total")  // /question/question/total
    public Result questionTotal() {
        return questionService.getQuestionTotal();
    }

}
