package com.example.mybatisplus1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.mybatisplus1.domain.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: EmployeeMapper
 * Author:   yangjian
 * Date:     2020/12/6 14:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/12/6 14:16        1.0              描述
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    
    List<Employee> getEmpList();
}
