package com.example.service;

import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;

@Service
public class AccountService {
    AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository ar) {
        this.accountRepository = ar;
    }

    public Account login(Account a) {
        return null;
    }
    public Account register(Account a) {
        return null;
    }
}
