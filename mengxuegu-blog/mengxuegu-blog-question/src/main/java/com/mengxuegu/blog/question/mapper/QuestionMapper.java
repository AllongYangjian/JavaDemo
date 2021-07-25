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

    /**
     * 通过问题id删除问题标签中间表
     * @param questionId
     * @return
     */
    boolean deleteQuestionLabel(@Param("questionId") String questionId);

    /**
     * 新增问题标签中间表数据
     * @param questionId 问题id
     * @param labelIds 标签id集合
     * @return
     */
    boolean saveQuestionLabel(@Param("questionId") String questionId,
                              @Param("labelIds") List<String> labelIds);
}
