package com.mengxuegu.blog.article.service.impl;

import com.mengxuegu.blog.article.req.LabelREQ;
import com.mengxuegu.blog.entities.Label;
import com.mengxuegu.blog.article.mapper.LabelMapper;
import com.mengxuegu.blog.article.service.ILabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengxuegu.blog.util.base.Result;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-20
 */
@Service
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements ILabelService {

    @Override
    public Result queryPage(LabelREQ req) {
        return Result.ok(baseMapper.queryPage(req.getPage(), req));
    }

    @Override
    public boolean updateById(Label entity) {
        entity.setUpdateDate(new Date());
        return super.updateById(entity);
    }
}
