package com.yj.jpa.test;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.yj.jpa.domain.Customer;
import com.yj.jpa.domain.Orders;
import org.hibernate.criterion.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: JPATest
 * Author:   yangjian
 * Date:     2020/11/14 16:48
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/14 16:48        1.0              描述
 */
public class JPATest {

    private EntityManagerFactory factory;
    private EntityManager manager;
    private EntityTransaction transaction;


    @Before
    public void init() {
        factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        manager = factory.createEntityManager();
        transaction = manager.getTransaction();
        transaction.begin();
    }

    /**
     * 在使用是在去查询数据库
     */
    @Test
    public void testGetReference() {
        Customer customer = manager.getReference(Customer.class, 1);
        System.err.println("-------------------");
        System.err.println(customer.toString());
    }

    /**
     * 直接发送sql
     */
    @Test
    public void testFind() {
        Customer customer = manager.find(Customer.class, 1);
        System.err.println("-------------------");
        System.err.println(customer.toString());
    }

    @Test
    public void testRemove() {
//        Customer customer = new Customer();
//        customer.setId(2);
//        manager.remove(customer); //无法移除游离对象

        //只能移除持久化对象
        Customer customer1 = manager.find(Customer.class, 2);
        manager.remove(customer1);
    }

    /**
     * 使对象有临时状态变成持久化状态
     */
    @Test
    public void testPersistence() {
        //进行持久化操作
        Customer customer = new Customer();
        customer.setAge(12);
        customer.setEmail("yj@allong.com");
        customer.setLastName("yang");
        customer.setBirthday(new Date());
        customer.setCreateTime(new Date());
//        customer.setId(100); //如果存在id，则会抛出异常
        manager.persist(customer);
    }

    /**
     * 类似hibernate的saveOrUpdate方法
     */
    @Test
    public void testMerge() {
        Customer customer = new Customer();
        customer.setAge(13);
        customer.setEmail("AAA@allong.com");
        customer.setLastName("sss");
        customer.setBirthday(new Date());
        customer.setCreateTime(new Date());
        //创建一个新的对象，把临时对象的属性赋值到新对象中，对新对象进行insert操作
        Customer customer2 = manager.merge(customer);
        System.err.println("customer:" + customer.getId());
        System.err.println("customer2:" + customer2.getId());

    }

    @Test
    public void testMerge2() {
        Customer customer = new Customer();
        customer.setAge(14);
        customer.setEmail("DDD@allong.com");
        customer.setLastName("SSS");
        customer.setBirthday(new Date());
        customer.setCreateTime(new Date());
        customer.setId(5);
        //创建一个新的对象，把临时对象的属性赋值到新对象中，对新对象进行insert操作
        Customer customer2 = manager.merge(customer);
        System.err.println("customer:" + customer.getId());
        System.err.println("customer2:" + customer2.getId());
    }

    @Test
    public void testFlush() {
        Customer customer = manager.find(Customer.class, 3);
        customer.setLastName("JJ");

        manager.flush();
    }

    @Test
    public void testManyToOne() {
        Customer customer = new Customer();
        customer.setAge(15);
        customer.setEmail("EEE@allong.com");
        customer.setLastName("EEE");
        customer.setBirthday(new Date());
        customer.setCreateTime(new Date());

        Orders orders1 = new Orders();
        orders1.setName("AAA");
        orders1.setCustomer(customer);

        Orders orders2 = new Orders();
        orders2.setName("BBB");
        orders2.setCustomer(customer);
        manager.persist(customer);
        manager.persist(orders1);
        manager.persist(orders2);
    }

    /**
     * 左外连接加载
     */
    @Test
    public void testManyToOneFind() {
        Orders orders = manager.find(Orders.class, 7);
        System.err.println(orders.getName());
        System.err.println(orders.getCustomer().toString());
    }

    /**
     * 删除多的一端
     */
    @Test
    public void testRemoveMany() {
        Orders orders = manager.find(Orders.class, 7);
        manager.remove(orders);
    }

    /**
     * 删除一的一段 无法删除
     * SQLIntegrityConstraintViolationException
     */
    @Test
    public void testRemoveOne() {
        Customer customer = manager.find(Customer.class, 6);
        manager.remove(customer);
    }

    @Test
    public void testOneToMany() {

    }


    @After
    public void destroy() {

        transaction.commit();
        manager.close();
        factory.close();

    }
}
