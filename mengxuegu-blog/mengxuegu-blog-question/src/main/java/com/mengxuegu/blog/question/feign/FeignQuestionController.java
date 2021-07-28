package com.mengxuegu.blog.question.feign;

import com.mengxuegu.blog.feign.IFeignQuestionController;
import com.mengxuegu.blog.feign.req.UserInfoREQ;
import com.mengxuegu.blog.question.service.IQuestionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: FeignQuestionController
 * Author:   yangjian
 * Date:     2021/7/28 22:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/28 22:41        1.0              描述
 */
@RestController
@Api(value = "被远程调用的问题微服务接口",description = "被远程调用的问题微服务接口")
public class FeignQuestionController implements IFeignQuestionController {

    @Autowired
    private IQuestionService questionService;
    @Override
    public boolean updateUserInfo(UserInfoREQ req) {
        return questionService.updateUserInfo(req);
    }
}
