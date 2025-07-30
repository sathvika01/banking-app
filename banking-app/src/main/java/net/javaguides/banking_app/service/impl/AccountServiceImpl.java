package net.javaguides.banking_app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.javaguides.banking_app.dto.AccountDto;
import net.javaguides.banking_app.entity.Account;
import net.javaguides.banking_app.mapper.AccountMapper;
import net.javaguides.banking_app.repository.AccountRepository;
import net.javaguides.banking_app.service.AccountService;

@Service // This automatically creates spring bean for this class
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository; //constructor Injection

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        // Logic to create a new account
        // This will typically involve converting the DTO to an entity,
        // saving it using a repository, and then converting it back to a DTO.
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account); // Save the account entity to the database
        return AccountMapper.mapToAccountDto(savedAccount); // Convert the saved entity back to a DTO
        
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));

            
        return AccountMapper.mapToAccountDto(account); // Convert the entity to DTO
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        
       double total =  account.getBalance() + amount;
       account.setBalance(total); // Update the balance
       Account savedAccount = accountRepository.save(account); // Save the updated account entity

        return AccountMapper.mapToAccountDto(savedAccount); // Convert the updated entity to DTO;
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance for withdrawal");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total); // Update the balance
        Account savedAccount = accountRepository.save(account); // Save the updated account entity
        return AccountMapper.mapToAccountDto(savedAccount); // Convert the updated entity to DTO
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
        
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));

        accountRepository.deleteById(id);


        
    }
    


}
