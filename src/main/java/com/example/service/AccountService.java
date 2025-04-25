package com.example.service;

import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;

@Service
public class AccountService {
    AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Checks login info for an existing account
    public Account login(Account a) {
        Account found = accountRepository.findByUsername(a.getUsername());
        // If no matching username is found, return null
        if (found == null) {
            return null;
        }
        // If the password for the matching username account doesn't match, return null
        if (!found.getPassword().equals(a.getPassword())) {
            return null;
        }
        // If login info matches, return the account
        return found;
    }

    // Registers a new account
    public Account register(Account a) {
        Account found = accountRepository.findByUsername(a.getUsername());
        // If the username is already found, return null
        if (found != null) {
            return null;
        }
        // If the account username is unique, save to the database and return the account
        return accountRepository.save(a);
    }

    // Used to check if an account id exists in createNewMessage()
    public boolean exists(int id) {
        return accountRepository.existsById(id);
    }
}
