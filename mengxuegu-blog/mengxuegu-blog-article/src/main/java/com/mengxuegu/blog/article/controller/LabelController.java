package com.mengxuegu.blog.article.controller;


import com.mengxuegu.blog.article.req.LabelREQ;
import com.mengxuegu.blog.article.service.ILabelService;
import com.mengxuegu.blog.entities.Label;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author yangjian
 * @since 2021-07-20
 */
@RestController
@RequestMapping("/label")
@Api(value = "标签管理接口", description = "标签信息的增删改查")
public class LabelController {

    @Autowired
    private ILabelService labelService;

    @ApiOperation("根据标签ID与分类id查询页面分页列表接口")
    @PostMapping("/search")
    public Result search(@RequestBody LabelREQ req) {
        return labelService.queryPage(req);
    }

    @ApiOperation("根据标签ID查询标签信息接口")
    @ApiImplicitParam(name = "id", value = "标签id", required = true)
    @GetMapping("/{id}")
    public Result view(@PathVariable String id) {
        return Result.ok(labelService.getById(id));
    }

    @ApiOperation("更新标签信息的接口")
    @PutMapping
    public Result update(@RequestBody Label label) {
        return Result.ok(labelService.updateById(label));
    }

    @ApiOperation("根据标签ID删除标签信息接口")
    @ApiImplicitParam(name = "id", value = "标签id", required = true)
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        return Result.ok(labelService.removeById(id));
    }

    @ApiOperation("新增标签信息的接口")
    @PostMapping
    public Result save(@RequestBody Label label){
        return Result.ok(labelService.save(label));
    }



}
