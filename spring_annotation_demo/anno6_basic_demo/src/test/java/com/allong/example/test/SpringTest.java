package com.allong.example.test;

import com.allong.example.domain.Account;
import com.allong.example.service.AccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("liwenhan");
        account.setMoney(25);
        accountService.save(account);
    }

    @Test
    public void testUpdate() {
        Account account = accountService.findById(2);
        if (account != null) {
            account.setMoney(100);
            accountService.update(account);
        }
    }

    @Test
    public void testDelete() {
        accountService.delete(1);
    }

    @Test
    public void testFindOne() {
        Account account = accountService.findById(2);
        System.err.println(account.toString());
    }

    @Test
    public void testFindAll() {
        List<Account> accouts = accountService.findAll();
        for (Account accout : accouts) {
            System.err.println(accout.toString());
        }
    }
}
