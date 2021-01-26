package com.example.demo.service.impl;

import com.example.demo.service.ProductService;
import com.example.demo.utils.Utils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ProductServiceImpl
 * Author:   yangjian
 * Date:     2021/1/26 21:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/1/26 21:39        1.0              描述
 */
@Service
@CacheConfig(cacheNames = "user")
public class ProductServiceImpl implements ProductService {

    @Cacheable(key = "#id",sync = true)
    @Override
    public String findAll(String id) {
        return Utils.getCurrentTime();
    }

    @CachePut(key = "#id")
    @Override
    public String update(String id) {
        return Utils.getCurrentTime();
    }

    @CacheEvict(key = "#id")
    @Override
    public String delete(String id) {
        return null;
    }

    @CacheEvict(allEntries = true)
    @Override
    public String deleteAll() {
        return Utils.getCurrentTime();
    }


}
