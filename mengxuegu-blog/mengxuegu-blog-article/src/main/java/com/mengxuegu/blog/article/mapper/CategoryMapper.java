package com.mengxuegu.blog.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengxuegu.blog.entities.Category;

import java.util.List;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ArticleMapper
 * Author:   yangjian
 * Date:     2021/7/19 22:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/19 22:42        1.0              描述
 */
public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> findCategoryAndLabel();
}
