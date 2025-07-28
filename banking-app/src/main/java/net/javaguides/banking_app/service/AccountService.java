package net.javaguides.banking_app.service;

import net.javaguides.banking_app.dto.AccountDto;
import net.javaguides.banking_app.entity.Account;


public interface AccountService {

    AccountDto createAccount(AccountDto accountDto); // Method to create a new account
    AccountDto getAccountById(Long id); // Method to retrieve an account by its ID
    AccountDto deposit(Long id, double amount); // Method to deposit money into an account
    AccountDto withdraw(Long id, double amount); // Method to withdraw money from an account


}
