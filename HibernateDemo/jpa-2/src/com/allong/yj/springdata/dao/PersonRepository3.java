package com.allong.yj.springdata.dao;

import com.allong.yj.springdata.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: PersonRepository3
 * Author:   yangjian
 * Date:     2020/12/10 22:10
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/12/10 22:10        1.0              描述
 */
public interface PersonRepository3 extends JpaRepository<Person,Integer>, JpaSpecificationExecutor<Person> {
}
