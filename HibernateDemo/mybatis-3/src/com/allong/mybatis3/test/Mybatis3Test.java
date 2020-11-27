package com.allong.mybatis3.test;


import com.allong.mybatis3.domain.Department;
import com.allong.mybatis3.domain.Employee;
import com.allong.mybatis3.mapper.DepartmentMapper;
import com.allong.mybatis3.mapper.EmployeeMapper;
import com.allong.mybatis3.mapper.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Mybatis3Test
 * Author:   yangjian
 * Date:     2020/11/21 22:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/21 22:56        1.0              描述
 */
public class Mybatis3Test {

    private static SqlSessionFactory factory;
    private static SqlSession session;
    private static EmployeeMapper mapper;
    private static EmployeeMapperPlus mapperPlus;

    static {
        String resource = "mybatis-config.xml";
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void init() {
        session = factory.openSession();
        mapper = session.getMapper(EmployeeMapper.class);
        mapperPlus = session.getMapper(EmployeeMapperPlus.class);
    }

    /**
     * 测试获取自增的主键值
     */
    @Test
    public void testSave() {
//        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setName("杨建ss");
        employee.setAge(28);
        employee.setAddress("浙江杭州");
        employee.setLastName("键");
        boolean result = mapper.addEmp(employee);
        System.err.println("保存" + (result ? "成功" : "失败") + employee.getId());
    }

    @Test
    public void testUpdate() {
//        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.findById(1);
        if (employee != null) {
            employee.setLastName("llll");
            boolean result = mapper.updateEmp(employee);
            System.err.println("更新" + (result ? "成功" : "失败"));
        }
    }


    @Test
    public void testDelete() {
        long id = mapper.deleteEmp(4);
        System.err.println("delete record index " + id);
    }

    @Test
    public void testResultList() {
        List<Employee> results = mapper.selectAll();
        System.err.println(results.toString());
    }

    @Test
    public void testResultMap() {
        Map<String, Object> maps = mapper.findByIdResultMap(1);
        System.err.println(maps.toString());
    }

    @Test
    public void testMapKeyValueEmployee() {
        Map<Integer, Employee> maps = mapper.findMapKey(1);
        System.err.println(maps.toString());
    }

    @Test
    public void testResultMapPlus() {
        Employee employee = mapperPlus.findById(1);
        System.err.println(employee.toString());
    }

    @Test
    public void testUnionMap() {
        Employee employee = mapperPlus.findUnionProperty(1);
        System.err.println(employee.toString());
    }

    /**
     * 通过 association 属性来指定关联复杂属性的名称和类型
     * property:属性名
     * javaType:类名称
     */
    @Test
    public void testUnionMapWithAssociation() {
        Employee employee = mapperPlus.findUnionProperty2(1);
        System.err.println(employee.toString());
    }


    @Test
    public void testUnionMapWithAssociation2() {
        Employee employee = mapperPlus.findByIdStep(5);
//        System.err.println(employee.getAddress());
        System.err.println(employee.toString());
    }

    @Test
    public void testDepartment() {
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
        Department department = mapper.findByIdPlus(1);
        System.err.println(department.toString());
    }

    /**
     * 分布式查询查询科室员工列表
     * 1、先查询科室
     * 2、在查询员工
     */
    @Test
    public void testDepartmentStep() {
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);

        Department department = mapper.findByIdStep(1);
        System.err.println(department.toString());
    }

    @After
    public void destroy() {
        session.commit();
        session.close();
    }


}
