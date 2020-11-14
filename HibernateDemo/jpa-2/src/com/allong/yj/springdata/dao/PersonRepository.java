package com.allong.yj.springdata.dao;

import com.allong.yj.springdata.entity.Person;
import org.springframework.data.repository.Repository;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: PersonRepository
 * Author:   yangjian
 * Date:     2020/11/15 0:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/15 0:29        1.0              描述
 */
public interface PersonRepository extends Repository<Person, Integer> {

    Person getByLastName(String lastName);

}
