package com.mengxuegu.blog.question.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mengxuegu.blog.entities.Question;
import com.mengxuegu.blog.question.mapper.QuestionMapper;
import com.mengxuegu.blog.question.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengxuegu.blog.util.base.BaseRequest;
import com.mengxuegu.blog.util.base.Result;
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



}
