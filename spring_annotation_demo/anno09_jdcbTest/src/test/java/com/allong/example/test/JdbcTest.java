package com.allong.example.test;

import com.allong.example.config.SpringApplication;
import com.allong.example.domain.Account;
import com.allong.example.domain.UserInfo;
import com.allong.example.jdbc.JdbcTemplate;
import com.allong.example.jdbc.handler.impl.BeanHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringApplication.class)
public class JdbcTest {

    @Autowired
    private JdbcTemplate template;

    @Test
    public void testSave(){
        Account account = (Account) template.query("select * from userinfo where id = ?",new BeanHandler<Account>(Account.class),2);
        System.err.println(account.toString());
//        template.query()
    }
}
