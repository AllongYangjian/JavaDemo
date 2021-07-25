package com.mengxuegu.blog.question.service;

import com.mengxuegu.blog.entities.Replay;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.util.base.Result;

/**
 * <p>
 * 回答信息表 服务类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-25
 */
public interface IReplayService extends IService<Replay> {
    /**
     * 通过问题id递归查询所有回答信息
     * @param questionId
     * @return
     */
    Result findByQuestionId(String questionId);

    /**
     * 通过回答评论id递归删除
     * @param id 回答评论id
     * @return
     */
    Result deleteById(String id);
}
