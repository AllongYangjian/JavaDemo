import com.yj.hibernate.domain.News;
import com.yj.hibernate.test.TestManyToOne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Timestamp;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Main
 * Author:   yangjian
 * Date:     2020/11/8 10:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/8 10:53        1.0              描述
 */
public class Main {

    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    private static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
//        testNews();
//        testIdGenerator();

        TestManyToOne.test();
    }

    public static void testNews() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            News news = session.find(News.class, 1);
            transaction.commit();
            System.err.println(news.toString());
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }


    public static void testIdGenerator() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        saveNews(session);
        saveNews(session);

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        transaction.commit();
        session.close();
    }

    private static void saveNews(Session session) {
        News news = new News();
        news.setTitle("AA");
        news.setAuthor("BB");
        news.setDate(new Timestamp(System.currentTimeMillis()));
        session.save(news);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
