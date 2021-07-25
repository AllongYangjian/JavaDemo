package com.mengxuegu.blog.question.service.impl;

import com.mengxuegu.blog.entities.QuestionLabel;
import com.mengxuegu.blog.question.mapper.QuestionLabelMapper;
import com.mengxuegu.blog.question.service.IQuestionLabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 问题标签中间表 服务实现类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-25
 */
@Service
public class QuestionLabelServiceImpl extends ServiceImpl<QuestionLabelMapper, QuestionLabel> implements IQuestionLabelService {

}
