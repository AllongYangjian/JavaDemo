package com.mengxuegu.blog.article.service;

import com.mengxuegu.blog.article.req.ArticleListREQ;
import com.mengxuegu.blog.article.req.ArticleREQ;
import com.mengxuegu.blog.article.req.ArticleUserREQ;
import com.mengxuegu.blog.entities.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mengxuegu.blog.feign.req.UserInfoREQ;
import com.mengxuegu.blog.util.base.Result;
import com.mengxuegu.blog.util.enums.ArticleStatusEnum;

/**
 * <p>
 * 文章信息表 服务类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-21
 */
public interface IArticleService extends IService<Article> {

    /**
     * 条件分页查询文章列表
     *
     * @param req
     * @return
     */
    Result queryPage(ArticleREQ req);

    /**
     * 查询文章详情接口
     *
     * @param id
     * @return
     */
    Result findArticleAndLabelById(String id);

    /**
     * 新增或保存文章信息
     * @param article
     * @return
     */
    Result updateOrSave(Article article);

    Result updateStatus(String id, ArticleStatusEnum statusEnum);

    /**
     * 根据用户id查询公开或未公开的文章列表
     * @param req
     * @return
     */
    Result findListByUserIdAndIsPublic(ArticleUserREQ req);

    /**
     * 更新文章点赞数量
     * @param id
     * @param count
     * @return
     */
    Result updateArticleThumb(String id,int count);

    /**
     * 更新文章浏览次数
     * @param id
     * @return
     */
    Result updateViewCount(String id);

    /**
     *根据分类ID或标签id查询文章分页列表
     * @param req
     * @return
     */
    Result findListByLabelIdOrCategoryId(ArticleListREQ req);

    /**
     * 查询已发布且审核通过的文章数
     * @return
     */
    Result getArticleTotal();

    /**
     * 统计每个分类下的文章数
     * @return
     */
    Result selectCategoryTotal();

    Result selectYearMonthTotal();

    boolean updateUserInfo(UserInfoREQ req);
}
