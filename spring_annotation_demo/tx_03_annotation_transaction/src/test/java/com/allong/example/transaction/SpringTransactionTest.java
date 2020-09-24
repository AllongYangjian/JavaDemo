package com.allong.example.transaction;

import com.allong.example.transaction.config.SpringApplication;
import com.allong.example.transaction.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringApplication.class)
public class SpringTransactionTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransaction(){
        accountService.transfer("yangjian","liwenhan",10d);
    }
}
