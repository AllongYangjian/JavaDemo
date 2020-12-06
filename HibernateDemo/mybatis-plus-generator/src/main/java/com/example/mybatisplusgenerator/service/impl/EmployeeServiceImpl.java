package com.example.mybatisplusgenerator.service.impl;

import com.example.mybatisplusgenerator.domain.Employee;
import com.example.mybatisplusgenerator.mapper.EmployeeMapper;
import com.example.mybatisplusgenerator.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨建
 * @since 2020-12-06
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
