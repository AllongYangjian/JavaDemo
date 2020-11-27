package com.yj.hibernate.test;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import com.yj.hibernate.foreign.Department;
import com.yj.hibernate.foreign.Manager;
import com.yj.hibernate.n21.Customer;
import com.yj.hibernate.n21.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: TestManyToOne
 * Author:   yangjian
 * Date:     2020/11/11 21:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/11 21:17        1.0              描述
 */
public class TestOneToOne {

    private static SessionFactory factory;

    private static Session session;

    private static Transaction transaction;

    private static void init() {
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
    }

    public static void test() {
        init();
        testMethod();
        destroy();
    }


    private static void testMethod() {
        testSave();
//        testSave2();

//        testUpdate();

//        testDeleteMany();

//        testDeleteOne();
    }

    /**
     * 测试多对一关系的保存方法
     * 3条 insert 语句
     */
    private static void testSave() {
        Manager manager = new Manager();
        manager.setName("manager1");

        Department department = new Department();
        department.setName("department2");
        department.setMgr(manager);

        session.save(department);
        session.save(manager);
    }

    /**
     * 测试保存，保存的对象先后顺序不一样
     * 3条 insert 语句
     * 2条 update 语句
     */
    private static void testSave2() {
        Customer customer = new Customer();
        customer.setName("AAA");

        Order order1 = new Order();
        order1.setName("Order-1");
        order1.setCustomer(customer);

        Order order2 = new Order();
        order2.setName("Order-2");
        order2.setCustomer(customer);

        session.save(order1);
        session.save(order2);

        session.save(customer);
    }

    public static void testUpdate() {
        //查询多的一端的对象时，不会查询1的于丹的独享
        Order order = session.get(Order.class, 3);
        //如果在使用Customer之前关闭了session,会发生懒加载异常 LazyInitializationException
//        session.close();
        Customer customer = order.getCustomer();
        System.err.println(customer.getName());
        customer.setName("BBB");

        session.update(customer);
    }

    private static void destroy() {
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void testDeleteMany() {
        Order order = session.get(Order.class, 3);
        session.delete(order);
    }

    /**
     * 存在主外键关联是，如果未设置级联删除，则会删除失败
     * Cannot delete or update a parent row: a foreign key constraint fails
     */
    public static void testDeleteOne() {
        Customer customer = session.get(Customer.class, 2);
        session.delete(customer);
    }
}
