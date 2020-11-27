package com.allong.mybatis4.test;

import com.allong.mybatis4.domain.Employee;
import com.allong.mybatis4.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: TestMybatis
 * Author:   yangjian
 * Date:     2020/11/25 22:26
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/25 22:26        1.0              描述
 */
public class TestMybatis {

    private static SqlSession session;
    private static EmployeeMapper mapper;

    static {
        String name = "mybatis-config.xml";
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(name));
            session = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void init() {
        mapper = session.getMapper(EmployeeMapper.class);
    }

    @Test
    public void testConditionSql() {
        Employee employee = new Employee();
//        employee.setId(1);
        employee.setName("yangjian");
        employee.setAddress("浙江杭州");
//        employee.setAge(28);
        List<Employee> condition = mapper.findCondition(employee);
        System.err.println(condition.toString());
    }


    @Test
    public void testConditionSqlTrim() {
        Employee employee = new Employee();
//        employee.setId(1);
//        employee.setName("yangjian");
//        employee.setAddress("浙江杭州");
        employee.setAge(10);
        List<Employee> condition = mapper.findConditionTrim(employee);
        System.err.println(condition.toString());
    }

    @Test
    public void testConditionSqlChooseWhen() {
        Employee employee = new Employee();
//        employee.setId(1);
        employee.setName("yangjian");
//        employee.setAddress("浙江杭州");
//        employee.setAge(10);
        List<Employee> condition = mapper.findConditionChooseWhen(employee);
        System.err.println(condition.toString());
    }

    @After
    public void destroy() {
        session.commit();
        session.close();
        ;
    }
}
