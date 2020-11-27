package com.yj.jpa.domain;

import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Main
 * Author:   yangjian
 * Date:     2020/11/12 23:43
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/12 23:43        1.0              描述
 */
public class Main {

    public static void main(String[] args) {
        //创建EntityManagerFactory

        String persistenceUnitName = "NewPersistenceUnit";
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnitName);

        //创建EntityManager
        EntityManager manager = factory.createEntityManager();

        //开启事务
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        //进行持久化操作
        Customer customer = new Customer();
        customer.setAge(12);
        customer.setEmail("yj@allong.com");
        customer.setLastName("yang");
        customer.setBirthday(new Date());
        customer.setCreateTime(new Date());

        manager.persist(customer);
        //提交事务
        transaction.commit();

        //关机EntityManager
        manager.clear();
        //关闭 EntityManagerFactory
        factory.close();
    }
}
