package com.allong.mybatis3.mapper;

import com.allong.mybatis3.domain.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

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
public interface EmployeeMapperPlus {

    Employee findById(Integer id);

    Employee findUnionProperty(Integer id);

    Employee findUnionProperty2(Integer id);

    Employee findByIdStep(Integer id);

    List<Employee> findEmployeeByDeptId(Integer deptId);

    /**
     * 通过鉴别器来设置查询条件
     *
     * @param id
     * @return
     */
    Employee findWithDiscriminator(Integer id);



}
