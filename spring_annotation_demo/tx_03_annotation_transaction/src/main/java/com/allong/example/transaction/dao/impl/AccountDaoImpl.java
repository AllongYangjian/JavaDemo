package com.allong.example.transaction.dao.impl;

import com.allong.example.transaction.dao.AccountDao;
import com.allong.example.transaction.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void Update(Account account) {
        jdbcTemplate.update("update account set name = ?,money = ? where id = ?",
                account.getName(),account.getMoney(),account.getId());
    }

    public Account findByName(String name) {
        return jdbcTemplate.queryForObject("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),name);
    }
}
