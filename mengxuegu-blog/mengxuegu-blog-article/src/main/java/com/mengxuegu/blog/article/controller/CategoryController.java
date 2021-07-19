package com.mengxuegu.blog.article.controller;

import com.mengxuegu.blog.article.req.CategoryREQ;
import com.mengxuegu.blog.article.service.ICategoryService;
import com.mengxuegu.blog.util.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * 分页条件查询
     * @param req
     * @return
     */
    @PostMapping("/search")
    public Result search(@RequestBody CategoryREQ req) {
        return categoryService.queryPage(req);
    }
}
