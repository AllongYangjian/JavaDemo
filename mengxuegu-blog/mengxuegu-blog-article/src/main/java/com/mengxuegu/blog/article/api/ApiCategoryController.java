package com.mengxuegu.blog.article.api;

import com.mengxuegu.blog.article.service.ICategoryService;
import com.mengxuegu.blog.util.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ApiCategoryController
 * Author:   yangjian
 * Date:     2021/7/20 23:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/20 23:41        1.0              描述
 */
@Api(value = "分类管理公共接口",description = "不需要通过身份认证就能访问")
@RestController
@RequestMapping("/api/category")
public class ApiCategoryController {

    @Autowired
    private ICategoryService categoryService;

    @ApiOperation("查询所有状态正常类别接口")
    @GetMapping("/list")
    public Result list() {
        return Result.ok(categoryService.findAllNormal());
    }

    @ApiOperation("查询正常分类下的标签列表")
    @GetMapping("/label/list")
    public Result findCategoryAndLabel() {
        return Result.ok(categoryService.findCategoryAndLabel());
    }
}
