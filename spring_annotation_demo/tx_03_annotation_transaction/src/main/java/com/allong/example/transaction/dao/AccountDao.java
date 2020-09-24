package com.allong.example.transaction.dao;

import com.allong.example.transaction.domain.Account;

public interface AccountDao {

    void Update(Account account);

    Account findByName(String name);
}
