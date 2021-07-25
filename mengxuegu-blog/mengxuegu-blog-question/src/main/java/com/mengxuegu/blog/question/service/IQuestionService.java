package com.mengxuegu.blog.question.service;

import com.mengxuegu.blog.entities.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.util.base.BaseRequest;
import com.mengxuegu.blog.util.base.Result;

/**
 * <p>
 * 问题信息表 服务类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-25
 */
public interface IQuestionService extends IService<Question> {

    /**
     * 查询热门问答列表
     * @param req
     * @return
     */
    Result findHotList(BaseRequest<Question> req);

    /**
     * 查询最新问答列表
     * @param req
     * @return
     */
    Result findNewList(BaseRequest<Question> req);

    /**
     * 查询等待问答列表
     * @param req
     * @return
     */
    Result findWaitList(BaseRequest<Question> req);
}
