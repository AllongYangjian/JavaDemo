package com.mengxuegu.blog.article.controller;

import com.mengxuegu.blog.util.aliyun.AliyunUtil;
import com.mengxuegu.blog.util.base.Result;
import com.mengxuegu.blog.util.enums.PlatformEnum;
import com.mengxuegu.blog.util.properties.AliyunProperties;
import com.mengxuegu.blog.util.properties.BlogProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: FileController
 * Author:   yangjian
 * Date:     2021/7/22 23:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/22 23:36        1.0              描述
 */
@Api(value = "文件管理接口",description = "文件管理接口，上传或删除图片")
@RequestMapping("/file")
@RestController
public class FileController {

    @Autowired
    private BlogProperties blogProperties;

    @ApiOperation("上传文件到OSS服务器")
//    @ApiImplicitParam(name = "file",value = "要上传的文件",required = true)
    @PostMapping("/upload")
    public Result upload(@RequestParam("file")MultipartFile file){
        AliyunProperties properties = blogProperties.getAliyun();
        return AliyunUtil.uploadFileToOss(PlatformEnum.ARTICLE,file,properties);
    }

    @ApiOperation("根据文件URL删除OSS中对应的文件")
    @ApiImplicitParam(name = "fileUrl",value = "要删除文件的URL",required = true)
    @DeleteMapping("/delete")
    public Result delete(@RequestParam(value = "fileUrl",required = true)String fileUrl){
        return AliyunUtil.delete(fileUrl,blogProperties.getAliyun());
    }
}
