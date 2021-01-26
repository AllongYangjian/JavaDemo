package com.example.demo.controller;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (C), 2015-2021, 杭州奥朗信息科技有限公司
 * FileName: ProductController
 * Author:   yangjian
 * Date:     2021/1/26 21:37
 * Description: product controller
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2021/1/26 21:37        1.0              描述
 */
@RestController
@RequestMapping("/product/findAll")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public String findAll(@PathVariable("id")String id){
        return service.findAll(id);
    }

    @PostMapping("/{id}")
    public String update(@PathVariable("id")String id){
        return service.update(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")String id){
        return service.delete(id);
    }

    @DeleteMapping
    public String deleteAll(){
        return service.deleteAll();
    }
}
