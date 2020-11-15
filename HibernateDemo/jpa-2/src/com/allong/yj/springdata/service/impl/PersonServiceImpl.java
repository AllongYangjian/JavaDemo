package com.allong.yj.springdata.service.impl;

import com.allong.yj.springdata.dao.PersonRepository;
import com.allong.yj.springdata.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: PersonServiceImpl
 * Author:   yangjian
 * Date:     2020/11/15 13:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/15 13:23        1.0              描述
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Transactional
    @Override
    public void updatePerson(String lastName, Integer id) {
        repository.updatePerson(lastName,id);
    }
}
