package com.example.tkmapper.mapper;

import com.example.tkmapper.domain.User;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.common.Mapper;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: UserMapper
 * Author:   yangjian
 * Date:     2020/12/3 22:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/12/3 22:34        1.0              描述
 */
@CacheNamespace
public interface UserMapper extends Mapper<User> {
}
