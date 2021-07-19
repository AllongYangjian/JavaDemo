package com.mengxuegu.blog.util.base;

import com.fasterxml.jackson.databind.util.EnumResolver;
import com.mengxuegu.blog.util.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: Result
 * Author:   yangjian
 * Date:     2021/7/19 21:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/19 21:26        1.0              描述
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(Result.class);


    /**
     * 响应业务状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private Object data;

    public static Result ok() {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getDesc(), null);
    }

    public static Result ok(Object data) {
        return new Result(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getDesc(), data);
    }

    public static Result ok(String message, Object data) {
        return new Result(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public static Result error(String msg) {
        logger.debug("返回错误:code={}，message={}", ResultEnum.ERROR.getCode(), msg);
        return new Result(ResultEnum.ERROR.getCode(), msg, null);
    }

    public static Result build(int code, String msg) {
        logger.debug("返回结果:code={}，message={}", code, msg);
        return new Result(code, msg, null);
    }

    public static Result build(ResultEnum resultEnum) {
        logger.debug("返回结果:code={}，message={}", resultEnum.getCode(), resultEnum.getDesc());
        return new Result(resultEnum.getCode(), resultEnum.getDesc(), null);
    }
}
