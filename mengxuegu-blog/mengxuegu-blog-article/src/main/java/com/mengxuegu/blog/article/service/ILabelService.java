package com.mengxuegu.blog.article.service;

import com.mengxuegu.blog.article.req.LabelREQ;
import com.mengxuegu.blog.entities.Label;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.util.base.Result;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-20
 */
public interface ILabelService extends IService<Label> {
    Result queryPage(LabelREQ req);
}
