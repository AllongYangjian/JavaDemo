package com.mengxuegu.blog.article.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mengxuegu.blog.entities.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mengxuegu.blog.feign.req.UserInfoREQ;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据分类ID或标签id查询文章分页列表
     * @param page
     * @param categoryId
     * @param labelId
     * @return
     */
    IPage<Article> findListByLabelIdOrCategoryId(IPage<Article> page,
                                                 @Param("categoryId")String categoryId,
                                                 @Param("labelId") String labelId);

    /**
     * 查询每个分类下文章数量
     * @return
     */
    List<Map<String,Object>> selectCategoryTotal();

    /**
     * 统计近六个月发布的文章数量
     * @return
     */
    List<Map<String,Object>> selectMonthArticleTotal();

    /**
     * 更新文章和评论表中的用户信息
     * @param req
     * @return
     */
    boolean updateUserInfo(UserInfoREQ req);
}
