package com.mengxuegu.blog.question.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mengxuegu.blog.entities.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 问题信息表 Mapper 接口
 * </p>
 *
 * @author yangjian
 * @since 2021-07-25
 */
public interface QuestionMapper extends BaseMapper<Question> {

    IPage<Question> findLabelQuestionList(IPage<Question> page,@Param("labelId") String labelId);

    /**
     * 根据问题id查询问题详情与属性标签ids
     * @param id
     * @return
     */
    Question findQuestionAndLabelIdsById(String id);
}
