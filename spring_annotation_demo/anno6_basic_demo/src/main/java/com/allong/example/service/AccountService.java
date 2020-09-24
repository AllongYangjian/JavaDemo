package com.allong.example.service;

import com.allong.example.domain.Account;

import java.util.List;

public interface AccountService {

    void save(Account account);

    void update(Account account);

    void delete(int id);

    Account findById(int id);

    List<Account> findAll();
}
