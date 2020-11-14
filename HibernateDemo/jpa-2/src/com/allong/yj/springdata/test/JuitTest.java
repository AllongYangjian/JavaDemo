package com.allong.yj.springdata.test;

import com.allong.yj.springdata.dao.PersonRepository;
import com.allong.yj.springdata.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: JuitTest
 * Author:   yangjian
 * Date:     2020/11/15 0:05
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/15 0:05        1.0              描述
 */
public class JuitTest {

    private static ApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = context.getBean(DataSource.class);
        System.err.println(dataSource.getConnection());
    }


    @Test
    public void testHelloWorldSpringData() {
        PersonRepository repository = context.getBean(PersonRepository.class);
        Person person = repository.getByLastName("yangjian");
        System.err.println(person.toString());
    }
}
