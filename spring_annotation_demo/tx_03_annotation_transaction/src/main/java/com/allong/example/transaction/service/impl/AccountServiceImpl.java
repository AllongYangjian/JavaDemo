package com.allong.example.transaction.service.impl;

import com.allong.example.transaction.dao.AccountDao;
import com.allong.example.transaction.domain.Account;
import com.allong.example.transaction.event.MyApplicationEvent;
import com.allong.example.transaction.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service("accountService")
//@Transactional//标明该类的所有方法都开启事务
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Transactional//标明该方法开启事务
    public void transfer(String sourceName, String targetName, Double money) {
        try {
            Account source = accountDao.findByName(sourceName);
            Account target = accountDao.findByName(targetName);
            source.setMoney((int) (source.getMoney() - money));
            target.setMoney((int) (target.getMoney() + money));
            accountDao.Update(source);
//            int y  =2/0;
            accountDao.Update(target);
        } finally {
            Map map = new HashMap();
            map.put("sourceName", sourceName);
            map.put("targetName", targetName);
            map.put("money", money);
            publisher.publishEvent(new MyApplicationEvent(map));
        }


    }
}
