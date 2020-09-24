package com.example.microservice.microserviceitem.controller;

import com.example.microservice.microserviceitem.domain.Item;
import com.example.microservice.microserviceitem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 对外提供接口，查询商品信息
     * @param id
     * @return
     */
    @GetMapping(value = "item/{id}")
    public Item queryItemById(@PathVariable("id") Long id){
        return itemService.queryItemById(id);
    }
}
