package com.allong.yj.springdata.test;

import com.allong.yj.springdata.dao.PersonPageAndSortRepository;
import com.allong.yj.springdata.dao.PersonRepository;
import com.allong.yj.springdata.dao.PersonRepository2;
import com.allong.yj.springdata.entity.Person;
import com.allong.yj.springdata.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private static PersonRepository repository;
    private static PersonService personService;

    private static PersonRepository2 personRepository2;

    static {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        repository = context.getBean(PersonRepository.class);

        personService = context.getBean(PersonService.class);

        personRepository2 = context.getBean(PersonRepository2.class);
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = context.getBean(DataSource.class);
        System.err.println(dataSource.getConnection());
    }

    @Test
    public void testSave() {
        PersonRepository repository = context.getBean(PersonRepository.class);
        for (int x = 0; x < 100; x++) {
            Person person = new Person();
            person.setBirth(new Date());
            person.setLastName("yangjian" + x);
            person.setEmail(x + "yy@qq.com");
            repository.save(person);
        }
    }

    @Test
    public void testQuery() {
        PersonRepository repository = context.getBean(PersonRepository.class);
//        List<Person> person = repository.getByLastNameStartingWithAndIdLessThan("yangjian8", 100);
//        List<Person> person = repository.getByLastNameEndingWithAndIdLessThan("8",100);
        List<String> strings = new ArrayList<>();
        strings.add("83yy@qq.com");
        strings.add("84yy@qq.com");
        List<Person> person = repository.getByEmailInOrBirthLessThan(strings, new Date());

        if (person != null && person.size() > 0) {
            System.err.println(person.size());
            for (Person item : person) {
                System.err.println(item.toString());
            }
        }
    }

    @Test
    public void testMaxIdPerson() {
        PersonRepository repository = context.getBean(PersonRepository.class);
        Person person = repository.getMaxIdPerson();
        System.err.println(person.toString());
    }

    @Test
    public void testHelloWorldSpringData() {
        PersonRepository repository = context.getBean(PersonRepository.class);
        Person person = repository.getByLastName("yangjian");
        System.err.println(person.toString());
    }

    @Test
    public void testAnnotation1() {
        PersonRepository repository = context.getBean(PersonRepository.class);
        Person person = repository.getAnnotationPerson("yangjian83", "83yy@qq.com");
        System.err.println(person.toString());
    }

    @Test
    public void testAnnotation2() {
        PersonRepository repository = context.getBean(PersonRepository.class);
        Person person = repository.getAnnotationPerson2("83yy@qq.com", "yangjian83");
        System.err.println(person.toString());
    }

    @Test
    public void testAnnotation3() {
        PersonRepository repository = context.getBean(PersonRepository.class);
        List<Person> personList = repository.getAnnotationPerson3("yangjian8", "qq.com");

        for (Person person : personList) {
            System.err.println(person.toString());
        }
    }

    @Test
    public void testNativeQuery() {
        PersonRepository repository = context.getBean(PersonRepository.class);
        long count = repository.getTotalCount();
        System.err.println("" + count);
    }

    @Test
    public void testUpdate() {
        personService.updatePerson("TEST", 1);
    }

    /**
     * CRUD接口批量保存操作
     */
    @Test
    public void testCrudRepositorySave() {
        List<Person> personList = new ArrayList<>();
        for (int x = 'a'; x < 'z'; x++) {
            Person person = new Person();
            person.setBirth(new Date());
            person.setEmail((char) x + "" + (char) x + "@qq.com");
            person.setLastName((char) x + "" + (char) x);

            personList.add(person);
        }
        personRepository2.saveAll(personList);
    }

    @Test
    public void testPagingAndSortRepository(){
        PersonPageAndSortRepository repository = context.getBean(PersonPageAndSortRepository.class);
        int pageNo = 3-1;
        int pageSize = 6;
        PageRequest request =  PageRequest.of(pageNo,pageSize);
        Page<Person> page = repository.findAll(request);
        System.err.println("总记录数："+page.getTotalElements());
        System.err.println("当前第几页："+(page.getNumber()+1));
        System.err.println("总页数："+page.getTotalPages());
        System.err.println("当前页面List:"+page.getContent());
        System.err.println("当前页面记录数："+page.getNumberOfElements());


    }
}
