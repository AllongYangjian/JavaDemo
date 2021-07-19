package com.mengxuegu.blog.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengxuegu.blog.article.mapper.CategoryMapper;
import com.mengxuegu.blog.article.req.CategoryREQ;
import com.mengxuegu.blog.article.service.ICategoryService;
import com.mengxuegu.blog.entities.Category;
import com.mengxuegu.blog.util.base.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: CategoryServiceImpl
 * Author:   yangjian
 * Date:     2021/7/19 22:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/19 22:51        1.0              描述
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Override
    public Result queryPage(CategoryREQ req) {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(req.getName())) {
            wrapper.like("name", req.getName());
        }
        if (req.getStatus() != null) {
            wrapper.eq("status", req.getStatus());
        }
        wrapper.orderByDesc("status").orderByAsc("sort");
        IPage<Category> categoryIPage = baseMapper.selectPage(req.getPage(), wrapper);

        return  Result.ok(categoryIPage.getRecords());
    }


}
