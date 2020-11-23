package com.allong.mybatis3.mapper;

import com.allong.mybatis3.domain.Department;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: DepartmentMapper
 * Author:   yangjian
 * Date:     2020/11/23 23:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/23 23:26        1.0              描述
 */
public interface DepartmentMapper {
    Department findById(Integer id);
}
