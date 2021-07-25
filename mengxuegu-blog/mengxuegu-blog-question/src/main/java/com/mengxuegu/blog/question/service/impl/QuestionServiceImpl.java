package com.mengxuegu.blog.question.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mengxuegu.blog.entities.Question;
import com.mengxuegu.blog.question.mapper.QuestionMapper;
import com.mengxuegu.blog.question.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengxuegu.blog.util.base.BaseRequest;
import com.mengxuegu.blog.util.base.Result;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 问题信息表 服务实现类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-25
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    @Override
    public Result findHotList(BaseRequest<Question> req) {
        QueryWrapper<Question> wrapper = new QueryWrapper<>();
        wrapper.ne("status", 0)
                .orderByDesc("reply");
        return Result.ok(baseMapper.selectPage(req.getPage(), wrapper));
    }

    @Override
    public Result findNewList(BaseRequest<Question> req) {
        QueryWrapper<Question> wrapper = new QueryWrapper<>();
        wrapper.ne("status", 0)
                .orderByDesc("update_date");
        return Result.ok(baseMapper.selectPage(req.getPage(), wrapper));
    }

    @Override
    public Result findWaitList(BaseRequest<Question> req) {
        QueryWrapper<Question> wrapper = new QueryWrapper<>();
        wrapper.ne("status", 0)
                .eq("reply",0)
                .orderByDesc("create_date");
        return Result.ok(baseMapper.selectPage(req.getPage(), wrapper));
    }

    /**
     * 根据标签id分页查询问题列表
     * @param req
     * @param labelId
     * @return
     */
    @Override
    public Result findLabelQuestionList(BaseRequest<Question> req,String labelId) {
        return Result.ok(baseMapper.findLabelQuestionList(req.getPage(),labelId));
    }


    @Override
    public Result findById(String id) {
        // 1. 查询问题详情与标签ids
        Question question = baseMapper.findQuestionAndLabelIdsById(id);

        if(question == null) {
            return Result.error("没有问题详情信息");
        }

        // TODO 2. Feign 远程调用  Article 服务查询标签信息
        if(CollectionUtils.isNotEmpty(question.getLabelIds())) {

        }

        return Result.ok(question);
    }

    @Override
    public Result updateViewCount(String id) {
        if(StringUtils.isEmpty(id)) {
            return Result.error("无效操作");
        }

        // 查询问题详情
        Question question = baseMapper.selectById(id);
        if(question == null) {
            return Result.error("问题不存在");
        }

        // 浏览数+1
        question.setViewCount( question.getViewCount() + 1 );
        baseMapper.updateById(question);

        return Result.ok();
    }
}
