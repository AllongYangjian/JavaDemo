import com.yj.hibernate.domain.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
        testNews();
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
}
