package com.example.service;

import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
        Account found = accountRepository.findByUsername(a.getUsername());
        if (found == null) {
            return null;
        }
        if (!found.getUsername().equals(a.getUsername()) || !found.getPassword().equals(a.getPassword())) {
            return null;
        }
        return found;
    }
    public Account register(Account a) {
        Account found = accountRepository.findByUsername(a.getUsername());
        if (found != null) {
            return null;
        }
        return accountRepository.save(a);
    }
}
