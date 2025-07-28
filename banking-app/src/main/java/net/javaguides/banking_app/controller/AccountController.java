package net.javaguides.banking_app.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.banking_app.dto.AccountDto;
import net.javaguides.banking_app.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService; //Constructor based Dependency Injection

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //Add account rest api
    //@RequestBody has JSON data and it automatically converts it to Java object
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);

    }

    //Get account by id rest api
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountbyId(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);

}
    //Deposit money into account rest api
    //just give the amount in json format in the request body
    @PutMapping("{id}/deposit") //http://localhost:8080/api/accounts/1/deposit
    public ResponseEntity<AccountDto> depositMoney(@PathVariable Long id, @RequestBody double amount){
        AccountDto updatedAccount = accountService.deposit(id, amount);
        return ResponseEntity.ok(updatedAccount);
    }

    //withdraw rest api
    @PutMapping("{id}/withdraw") //http://localhost:8080/api/accounts/1/withdraw
    public ResponseEntity<AccountDto> withdrawMoney(@PathVariable Long id, 
    @RequestBody Map<String, Double> request){

        Double amount = request.get("amount");
        AccountDto updatedAccount = accountService.withdraw(id, amount);
        return ResponseEntity.ok(updatedAccount);
    }

}
