package com.allong.example.dao.impl;

import com.allong.example.dao.AccountDao;
import com.allong.example.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate template;

    public void save(Account account) {
        template.update("insert into account(name,money) values(?,?)", account.getName(), account.getMoney());
    }

    public void update(Account account) {
        template.update("update account set name = ?,money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }

    public void delete(int id) {
        template.update("delete from account where id = ?", id);
    }

    public Account findById(int id) {
        List<Account> accounts = template.query("select * from account where id  = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    public List<Account> findAll() {
        return template.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
    }
}
