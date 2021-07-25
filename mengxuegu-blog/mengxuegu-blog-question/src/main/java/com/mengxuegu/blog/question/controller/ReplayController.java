package com.mengxuegu.blog.question.controller;


import com.mengxuegu.blog.entities.Replay;
import com.mengxuegu.blog.question.service.IReplayService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("新增回答信息接口")
    @PostMapping
    public Result add(@RequestBody Replay replay) {
        return replayService.add(replay);
    }

}
