package com.mengxuegu.blog.article.feign;

import com.mengxuegu.blog.article.service.ILabelService;
import com.mengxuegu.blog.entities.Label;
import com.mengxuegu.blog.feign.IFeignArticleController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: FeignArticleController
 * Author:   yangjian
 * Date:     2021/7/25 23:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/25 23:57        1.0              描述
 */
@RestController
@Api(value = "被远程调用的文章微服务接口",description = "被远程调用的文章微服务接口")
public class FeignArticleController implements IFeignArticleController {

    @Autowired
    private ILabelService labelService;

    @Override
    public List<Label> getLabelListByIds(List<String> labelIds) {
        return labelService.listByIds(labelIds);
    }
}
