package com.example.demo.service;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ProductService
 * Author:   yangjian
 * Date:     2021/1/26 21:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/1/26 21:38        1.0              描述
 */
public interface ProductService {

    String findAll(String id);

    String update(String id);

    String delete(String id);

    String deleteAll();

}
