import com.mysql.cj.jdbc.Driver;
import com.yj.hibernate.domain.Address;
import com.yj.hibernate.domain.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
//        testAddress();
        try {
            testJdbc();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static void testJdbc() throws Exception {
//        DriverManager.registerDriver(new Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate?serverTimezone=UTC",
                "root", "allong");
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        String sql = "select * from address where id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, 1);
            resultSet = ps.executeQuery();
            List<Address> list = new ArrayList<>();
            while (!resultSet.isLast()) {
                resultSet.next();
                int id = resultSet.getInt(1);
                String address = resultSet.getString(2);
                String remark = resultSet.getString(3);
                Address address1 = new Address(id, address, remark);
                list.add(address1);

            }
            System.err.println(list.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
