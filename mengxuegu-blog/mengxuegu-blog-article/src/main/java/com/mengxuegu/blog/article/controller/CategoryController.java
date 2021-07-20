package com.mengxuegu.blog.article.controller;

import com.mengxuegu.blog.article.req.CategoryREQ;
import com.mengxuegu.blog.article.service.ICategoryService;
import com.mengxuegu.blog.entities.Category;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: CategoryController
 * Author:   yangjian
 * Date:     2021/7/19 23:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/19 23:01        1.0              描述
 */
@RestController
@RequestMapping("/category")
@Api(value = "分类管理接口", description = "分类管理接口，提供分类的增删改查")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * 分页条件查询
     *
     * @param req
     * @return
     */
    @ApiOperation("根据分类名称和状态查询分类列表")
    @PostMapping("/search")
    public Result search(@RequestBody CategoryREQ req) {
        return categoryService.queryPage(req);
    }


    @ApiOperation("根据id查询类别详情接口")
    @ApiImplicitParam(name = "id", value = "类别ID", required = true)
    @GetMapping("/{id}")
    public Result view(@PathVariable("id") String id) {
        return Result.ok(categoryService.getById(id));
    }

    @ApiOperation("修改类别信息接口")
    @PutMapping
    public Result update(@RequestBody Category category) {
        return Result.ok(categoryService.updateById(category));
    }

    @ApiOperation("新增类别信息接口")
    @PostMapping
    public Result save(@RequestBody Category category) {
        return Result.ok(categoryService.save(category));
    }

    @ApiOperation("删除类别信息接口")
    @ApiImplicitParam(name = "id",value = "类别ID",required = true)
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        return Result.ok(categoryService.removeById(id));
    }

    @ApiOperation("查询所有类别接口")
    @GetMapping("/list")
    public Result list(){
        return Result.ok(categoryService.findAllNormal());
    }
}
