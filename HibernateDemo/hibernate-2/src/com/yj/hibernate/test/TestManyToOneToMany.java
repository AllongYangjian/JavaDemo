package com.yj.hibernate.test;

import com.yj.hibernate.n212n.Customer1;
import com.yj.hibernate.n212n.Order1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: TestManyToOne
 * Author:   yangjian
 * Date:     2020/11/11 21:17
 * Description: 双向多对一关系
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/11 21:17        1.0              描述
 */
public class TestManyToOneToMany {

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
//        testSave();

//        testGet();
//        testSave2();

//        testUpdate();

//        testDeleteMany();

        testDeleteOne();
    }

    /**
     * 测试多对一关系的保存方法
     * 3条 insert 语句
     */
    private static void testSave() {
        Customer1 customer = new Customer1();
        customer.setName("BBB");

        Order1 order1 = new Order1();
        order1.setName("Order-3");
        order1.setCustomer(customer);

        Order1 order2 = new Order1();
        order2.setName("Order-4");
        order2.setCustomer(customer);

        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        session.save(customer);
        session.save(order1);
        session.save(order2);
    }

    /**
     * 测试保存，保存的对象先后顺序不一样
     * 3条 insert 语句
     * 2条 update 语句
     */
    private static void testSave2() {
        Customer1 customer = new Customer1();
        customer.setName("AAA");

        Order1 order1 = new Order1();
        order1.setName("Order-1");
        order1.setCustomer(customer);

        Order1 order2 = new Order1();
        order2.setName("Order-2");
        order2.setCustomer(customer);

        session.save(order1);
        session.save(order2);

        session.save(customer);
    }

    public static void testGet() {
        Customer1 customer = session.get(Customer1.class, 1);
        System.err.println(customer.getName());
//        org.hibernate.collection.internal.PersistentSet
        //因为hibernate得到的类型为代理类型，因此需要将集合设置成接口类型
        System.err.println(customer.getOrders().getClass().getName());
    }

    public static void testUpdate() {
        //查询多的一端的对象时，不会查询1的于丹的独享
        Order1 order = session.get(Order1.class, 1);
        //如果在使用Customer之前关闭了session,会发生懒加载异常 LazyInitializationException
//        session.close();
        Customer1 customer = order.getCustomer();
        System.err.println(customer.getName());
        customer.setName("CCC");

        session.update(customer);
    }

    private static void destroy() {
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void testDeleteMany() {
        Order1 order = session.get(Order1.class, 3);
        session.delete(order);

    }

    /**
     * 存在主外键关联是，如果未设置级联删除，则会删除失败
     * Cannot delete or update a parent row: a foreign key constraint fails
     */
    public static void testDeleteOne() {
        Customer1 customer = session.get(Customer1.class, 1);
        session.delete(customer);
    }
}
