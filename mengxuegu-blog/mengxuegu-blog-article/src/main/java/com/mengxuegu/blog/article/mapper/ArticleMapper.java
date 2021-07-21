package com.mengxuegu.blog.article.mapper;

import com.mengxuegu.blog.entities.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 文章信息表 Mapper 接口
 * </p>
 *
 * @author yangjian
 * @since 2021-07-21
 */
public interface ArticleMapper extends BaseMapper<Article> {

    Article findArticleAndLabelById(String id);

    /**
     * 根据id删除文章信息
     * @param articleId
     * @return
     */
    boolean deleteArticleLabel(@Param("articleId") String articleId);

    /**
     * 保存文章标签信息
     * @param articleId
     * @param labelIds
     * @return
     */
    boolean saveArticleLabel(@Param("articleId") String articleId,@Param("labelIds") List<String> labelIds);
}
