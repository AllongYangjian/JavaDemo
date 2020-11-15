package com.allong.yj.springdata.dao;

import com.allong.yj.springdata.entity.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: PersonPageAndSortRepository
 * Author:   yangjian
 * Date:     2020/11/15 13:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/15 13:33        1.0              描述
 */
public interface PersonPageAndSortRepository extends PagingAndSortingRepository<Person,Integer> {

}
