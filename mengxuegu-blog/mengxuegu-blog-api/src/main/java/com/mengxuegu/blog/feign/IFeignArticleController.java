package com.mengxuegu.blog.feign;

import com.mengxuegu.blog.entities.Label;
import com.mengxuegu.blog.feign.req.UserInfoREQ;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: IFeignArticleController
 * Author:   yangjian
 * Date:     2021/7/25 23:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/25 23:51        1.0              描述
 */
//指定目标微服务的名字,和目标微服务的上下文路径地址
@FeignClient(value = "article-server",path = "/article")
public interface IFeignArticleController {

    /**
     *
     * @param labelIds
     * @return
     */
    @ApiOperation("Feign接口，根据标签列表查询标签信息")
    @ApiImplicitParam(allowMultiple = true,dataType = "String",name = "ids",value = "标签ID 集合",required = true)
    @GetMapping("/api/feign/label/list/{ids}")
    List<Label> getLabelListByIds(@PathVariable("ids")List<String> labelIds);

    @ApiOperation("Feign接口-更新文章表和评论表中的用户信息")
    @PutMapping("/feign/article/user")
    boolean updateUserInfo(@RequestBody UserInfoREQ req);
}
