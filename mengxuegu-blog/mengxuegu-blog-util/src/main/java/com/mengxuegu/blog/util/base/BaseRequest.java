package com.mengxuegu.blog.util.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: BaseRequest
 * Author:   yangjian
 * Date:     2021/7/19 21:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/7/19 21:12        1.0              描述
 */
@Data
@Accessors(chain = true)
public class BaseRequest<T> implements Serializable {

    @ApiModelProperty(value = "页码", required = true)
    private long current;

    @ApiModelProperty(value = "每页显示多少条", required = true)
    private long size;

    /**
     *
     * @return 分页对象
     */
    @ApiModelProperty(hidden = true)
    public IPage<T> getPage() {
        return new Page<T>().setCurrent(current).setSize(size);
    }
}
