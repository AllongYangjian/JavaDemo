package com.yj.mybatis.test;


import com.yj.mybatis.domain.Employee;
import com.yj.mybatis.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: MybatisTest
 * Author:   yangjian
 * Date:     2020/11/17 21:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/17 21:41        1.0              描述
 */
public class MybatisTest {

    private static SqlSessionFactory factory;
    private static SqlSession session;

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Before
    public void init() {
        session = factory.openSession();
    }

    @Test
    public void test() throws IOException {
        //此处的 com.yj.mybatis.mapper.EmployeeMapper.findById 是随意指定
        //如果需要指定参数的类型，则可以上namespace设置成 接口全路径名称，id设置成方法名称
        Object o = session.selectOne("com.yj.mybatis.mapper.EmployeeMapper.findById", 1);
        System.err.println(o.toString());

    }

    @Test
    public void testUpgrade() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        //mapper是代理对象
        System.err.println(mapper.getClass().getName());
        Employee employee = mapper.findById(1);
        System.err.println(employee.toString());
    }

    @After
    public void destroy() {
        session.close();
    }

}
