package com.allong.mybatis3.test;


import com.allong.mybatis3.domain.Employee;
import com.allong.mybatis3.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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
        System.err.println("保存" + (result ? "成功" : "失败")+employee.getId());
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

    @After
    public void destroy() {
        session.commit();
        session.close();
    }


}
