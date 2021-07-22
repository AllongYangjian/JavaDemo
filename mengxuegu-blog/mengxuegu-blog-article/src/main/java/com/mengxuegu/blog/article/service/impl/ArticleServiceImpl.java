package com.mengxuegu.blog.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.mengxuegu.blog.article.req.ArticleListREQ;
import com.mengxuegu.blog.article.req.ArticleREQ;
import com.mengxuegu.blog.article.req.ArticleUserREQ;
import com.mengxuegu.blog.entities.Article;
import com.mengxuegu.blog.article.mapper.ArticleMapper;
import com.mengxuegu.blog.article.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mengxuegu.blog.util.base.Result;
import com.mengxuegu.blog.util.enums.ArticleStatusEnum;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 文章信息表 服务实现类
 * </p>
 *
 * @author yangjian
 * @since 2021-07-21
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Override
    public Result queryPage(ArticleREQ req) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(req.getTitle())) {
            wrapper.like("title", req.getTitle());
        }
        if (req.getStatus() != null) {
            wrapper.eq("status", req.getStatus());
        }
        wrapper.orderByDesc("update_date");
        return Result.ok(baseMapper.selectPage(req.getPage(), wrapper));
    }

    @Override
    public Result findArticleAndLabelById(String id) {
        return Result.ok(baseMapper.findArticleAndLabelById(id));
    }

    @Override
    public Result updateOrSave(Article article) {
        if (StringUtils.isNotEmpty(article.getId())) {
            baseMapper.deleteArticleLabel(article.getId());
            article.setUpdateDate(new Date());
        }
        if (article.getIspublic() == 0) {
            article.setStatus(ArticleStatusEnum.SUCCESS.getCode());
        } else {
            article.setStatus(ArticleStatusEnum.WAIT.getCode());
        }
        super.saveOrUpdate(article);
        if (CollectionUtils.isNotEmpty(article.getLabelIds())) {
            baseMapper.saveArticleLabel(article.getId(), article.getLabelIds());
        }
        return Result.ok(article.getId());
    }

    @Override
    public Result updateStatus(String id, ArticleStatusEnum statusEnum) {
        UpdateWrapper<Article> wrapper = new UpdateWrapper<>();
        wrapper.set("status", statusEnum.getCode())
                .set("update_date", new Date())
                .eq("id", id);
        return Result.ok(update(wrapper));
    }

    @Override
    public Result findListByUserIdAndIsPublic(ArticleUserREQ req) {
        if (StringUtils.isEmpty(req.getUserId())) {
            return Result.error("无效的用户信息");
        }
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", req.getUserId());
        if (req.getIsPublic() != null) {
            wrapper.eq("ispublic", req.getIsPublic());
        }
        return Result.ok(baseMapper.selectPage(req.getPage(), wrapper));
    }

    @Override
    public Result updateArticleThumb(String id, int count) {
        if (count != 1 && count != -1) {
            return Result.error("无效操作");
        }
        if (StringUtils.isEmpty(id)) {
            return Result.error("无效操作");
        }

        Article article = getById(id);
        if (article == null) {
            return Result.error("文章不存在");
        }
        if (article.getThumhup() <= 0 && count == -1) {
            return Result.error("无效操作");
        }
        article.setThumhup(article.getThumhup() + 1);
        baseMapper.updateById(article);
        return Result.ok();
    }

    @Override
    public Result updateViewCount(String id) {
        if (StringUtils.isBlank(id)) {
            return Result.error("无效操作");
        }
        Article article = getById(id);
        if (article == null) {
            return Result.error("无效操作");
        }
        article.setViewCount(article.getViewCount() + 1);
        return Result.ok();
    }

    @Override
    public Result findListByLabelIdOrCategoryId(ArticleListREQ req) {
        return Result.ok(baseMapper.findListByLabelIdOrCategoryId(req.getPage(), req.getCategoryId(), req.getLabelId()));
    }

    @Override
    public Result getArticleTotal() {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("status", ArticleStatusEnum.SUCCESS.getCode())
                .eq("ispublic", 1);
        return Result.ok(count(wrapper));
    }

    @Override
    public Result selectCategoryTotal() {
        List<Map<String, Object>> maps = baseMapper.selectCategoryTotal();
        List<Object> nameList = new ArrayList<>();
        for (Map<String, Object> map : maps) {
            nameList.add(map.get("name"));
        }
        Map<String, Object> data = new HashMap<>();
        data.put("nameList", nameList);
        data.put("nameAndValueList", maps);
        return Result.ok(data);
    }
}
