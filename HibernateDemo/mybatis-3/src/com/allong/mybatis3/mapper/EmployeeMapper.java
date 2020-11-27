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
public interface EmployeeMapper {

    Employee findById(Integer id);

    /**
     * nmybatis 允许返回值直接定义为 Integer Long Boolean void 类型
     *
     * @param employee
     * @return
     */
    boolean addEmp(Employee employee);

    boolean updateEmp(Employee employee);

    long deleteEmp(Integer id);

    List<Employee> selectAll();

    Map<String, Object> findByIdResultMap(Integer id);

    //指定哪个列作为map的key
    @MapKey("id")
    Map<Integer, Employee> findMapKey(Integer id);
}
