package com.mengxuegu.blog.article.req;

import com.mengxuegu.blog.entities.Category;
import com.mengxuegu.blog.util.base.BaseRequest;
import lombok.Data;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: CategoryREQ
 * Author:   yangjian
 * Date:     2021/7/19 22:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/19 22:40        1.0              描述
 */
@Data
public class CategoryREQ extends BaseRequest<Category> {
    /**
     * 分类名称
     */
    private String name;

    /**
     * 状态
     */
    private String status;
}
