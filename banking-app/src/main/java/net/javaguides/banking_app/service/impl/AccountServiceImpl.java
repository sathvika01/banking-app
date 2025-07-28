package net.javaguides.banking_app.service.impl;

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
    


}
