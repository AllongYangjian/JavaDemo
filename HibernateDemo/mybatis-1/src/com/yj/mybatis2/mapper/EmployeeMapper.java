package com.yj.mybatis2.mapper;

import com.yj.mybatis2.domain.Employee;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: EmployeeMapper
 * Author:   yangjian
 * Date:     2020/11/17 21:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/17 21:38        1.0              描述
 */
public interface EmployeeMapper {

    Employee findById(Integer id);
}
