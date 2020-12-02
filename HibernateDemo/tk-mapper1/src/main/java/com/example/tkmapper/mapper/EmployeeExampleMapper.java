package com.example.tkmapper.mapper;

import com.example.tkmapper.domain.Employee;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: EmployeeMapper
 * Author:   yangjian
 * Date:     2020/12/2 20:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/12/2 20:52        1.0              描述
 */
public interface EmployeeExampleMapper extends ExampleMapper<Employee>, RowBoundsMapper<Employee> {

}
