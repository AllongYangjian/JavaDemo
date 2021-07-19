package com.mengxuegu.blog.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.article.req.CategoryREQ;
import com.mengxuegu.blog.entities.Category;
import com.mengxuegu.blog.util.base.Result;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ICategoryService
 * Author:   yangjian
 * Date:     2021/7/19 22:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/19 22:50        1.0              描述
 */
public interface ICategoryService extends IService<Category> {

    /**
     * 分页条件查询分类信息
     * @param req 条件
     * @return
     */
    Result queryPage(CategoryREQ req);
}
