package com.mengxuegu.blog.question.controller;


import com.mengxuegu.blog.question.service.IReplayService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 回答信息表 前端控制器
 * </p>
 *
 * @author yangjian
 * @since 2021-07-25
 */
@RestController
@RequestMapping("/replay")
public class ReplayController {
    @Autowired
    private IReplayService replayService;

    @ApiOperation("删除回答评论接口")
    @ApiImplicitParam(name = "id", value = "回答评论id", required = true)
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id) {
        return replayService.deleteById(id);
    }

}
