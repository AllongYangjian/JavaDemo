import com.yj.hibernate.domain.Address;
import com.yj.hibernate.domain.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Timestamp;

/**
 * Copyright (C), 2015-2020, 杭州奥朗信息科技有限公司
 * FileName: Main
 * Author:   yangjian
 * Date:     2020/11/7 22:46
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * yangjian       2020/11/7 22:46        1.0              描述
 */
public class Main {
    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration().configure();
        //4.0创建方法
        sessionFactory = configuration.buildSessionFactory();
    }

    private static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
//        testNews();
        testAddress();
    }

    private static void testAddress() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Address address = new Address();
            address.setAddress("浙江杭州拱墅");
            address.setRemark("家");
            session.save(address);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public static void testNews() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            News news = new News();
            news.setTitle("1");
            news.setAuthor("yj");
            news.setDate(new Timestamp(System.currentTimeMillis()));
            session.save(news);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
