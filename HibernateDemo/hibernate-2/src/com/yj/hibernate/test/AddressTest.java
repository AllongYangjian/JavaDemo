package com.yj.hibernate.test;


import com.yj.hibernate.domain.Address;
import com.yj.hibernate.domain.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;


public class AddressTest {

    private SessionFactory factory;

    private Session session;

    private Transaction transaction;

    @Before
    public void init() {
//        System.err.println("init");
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
    }

    @Test
    public void testAddressQuery() {
//        System.err.println("testAddressQuery");

        Address address = session.find(Address.class, 1);
        address.setAddress("浙江杭州拱墅");
        System.err.println(address.toString());

    }

    @Test
    public void testIdGenerator() throws InterruptedException {
        News news = new News();
        news.setTitle("AA");
        news.setAuthor("BB");
        news.setDate(new Timestamp(System.currentTimeMillis()));

        session.save(news);
        Thread.sleep(5000);
    }

    @After
    public void destroy() {
//        System.err.println("destroy");
        transaction.commit();
        session.close();
        factory.close();
    }
}