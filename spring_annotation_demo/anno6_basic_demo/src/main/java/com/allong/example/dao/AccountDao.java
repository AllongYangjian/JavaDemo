package com.allong.example.dao;

import com.allong.example.domain.Account;

import java.util.List;

public interface AccountDao {

    void save(Account account);

    void update(Account account);

    void delete(int id);

    Account findById(int id);

    List<Account> findAll();
}
