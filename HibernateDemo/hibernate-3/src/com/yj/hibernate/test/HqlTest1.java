package com.yj.hibernate.test;

import com.yj.hibernate.domain.EdrBaseReqlog;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.w3c.dom.ls.LSResourceResolver;

import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: HqlTest1
 * Author:   yangjian
 * Date:     2020/11/12 21:16
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/12 21:16        1.0              描述
 */
public class HqlTest1 {

    private static SessionFactory factory;

    private static Session session;

    private static Transaction ta;

    private static void init() {
        Configuration configuration = new Configuration().configure();
        factory = configuration.buildSessionFactory();

        session = factory.openSession();

        ta = session.beginTransaction();
    }

    public static void testMethod() {
        init();
        test();
        destroy();
    }

    private static void test() {
//        testQuery2();

//        testPageQuery();
//        testNamedQuery();

//        testPropertyQuery();
//        testPropertyQuery2();

//        testQbc();

//        testNativeSql();

        testSecondCache();
    }

    /**
     * j基于位置参数
     */
    private static void testQuery() {
        String hql = "from EdrBaseReqlog e where e.reqUrl like ?1";
        Query query = session.createQuery(hql);

        query.setString(1, "%a%");
        List<EdrBaseReqlog> logs = query.list();

        System.err.println(logs.size());
    }

    /**
     * 基于命名参数
     */
    private static void testQuery2() {
        String hql = "from EdrBaseReqlog e where e.reqUrl like :url";
        Query query = session.createQuery(hql);
        query.setString("url", "%B%");

        List<EdrBaseReqlog> logs = query.list();

        System.err.println(logs.size());
    }

    private static void testPageQuery() {
        String hql = "from EdrBaseReqlog";
        Query query = session.createQuery(hql);

        int pageNo = 3;
        int pageSize = 5;

        List<EdrBaseReqlog> emps = query.setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
        System.err.println(emps.toString());
    }

    public static void testNamedQuery() {
        Query query = session.getNamedQuery("logQuery");
        query.setString("name", "试一下");


        List<EdrBaseReqlog> list = query.list();
        System.err.println(list.size());
    }

    /**
     * 投影查询
     */
    private static void testPropertyQuery2() {
        String hql = "select new EdrBaseReqlog(e.loginname,e.reqUrl) from EdrBaseReqlog e where e.loginname = :name";
        Query query = session.createQuery(hql);

        query.setString("name", "试一下");
        List<EdrBaseReqlog> data = query.list();
        for (EdrBaseReqlog log : data) {
            System.err.println(log.getLoginname() + "," + log.getReqUrl());
        }
    }

    /**
     * 投影查询
     */
    private static void testPropertyQuery() {
        String hql = "select e.loginname,e.reqUrl from EdrBaseReqlog e where e.loginname = :name";
        Query query = session.createQuery(hql);

        query.setString("name", "试一下");

        List<Object[]> data = query.list();
        for (Object[] item : data) {
            System.err.println(Arrays.asList(item));
        }
    }

    private static void testBaoBiao() {

    }

    private static void testQbc() {
        Criteria criteria = session.createCriteria(EdrBaseReqlog.class);
        criteria.add(Restrictions.eq("loginname", "试一下"));
        List<EdrBaseReqlog> list = criteria.list();
        System.err.println(list.size());
    }

    private static void testNativeSql() {
        String sql = "insert into sys_role (name,enable) values(?,?)";
        Query query = session.createSQLQuery(sql);

        query.setString(1, "Test")
                .setInteger(2, 1)
                .executeUpdate();
    }

    private static void testSecondCache() {
        EdrBaseReqlog log1 = session.get(EdrBaseReqlog.class, 1);
        ta.commit();
        session.close();

        session = factory.openSession();

        ta = session.beginTransaction();
        EdrBaseReqlog log2 = session.get(EdrBaseReqlog.class, 1);

        System.err.println(log1.getReqUrl());

        System.err.println(log2.getReqUrl());
    }

    private static void destroy() {
        ta.commit();
        session.close();

        factory.close();
    }
}
