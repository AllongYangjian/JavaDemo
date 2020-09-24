package com.example.microservice.microserviceorder.service;

import com.example.microservice.microserviceorder.domain.Item;
import com.example.microservice.microserviceorder.properties.OrderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemService {

    @Autowired
    private RestTemplate restTemplate;

//    @Value("${myspcloud.item.url}")
//    private String itemUrl;

    /**
     * 采用配置类的方式注入属性信息
     */
    @Autowired
    private OrderProperties orderProperties;

    public Item queryItemById(Long id){
        String itemUrl = "http://app-item/item/{id}";
        Item result = restTemplate.getForObject(itemUrl,Item.class,id);

        System.err.println(result.toString());
        return result;
//        return restTemplate.getForObject(orderProperties.getItem().getUrl()+id,Item.class);

    }
}
