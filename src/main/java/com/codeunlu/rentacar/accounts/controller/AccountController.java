package com.codeunlu.rentacar.accounts.controller;

import com.codeunlu.rentacar.accounts.dto.AccountDto;
import com.codeunlu.rentacar.accounts.dto.UpdateAccountInfoDto;
import com.codeunlu.rentacar.accounts.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Boolean> createAccount(@RequestBody AccountDto account){
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccount(){
        return ResponseEntity.ok(accountService.getAllAccount());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id){
        return ResponseEntity.ok(accountService.getAccount(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(@RequestBody UpdateAccountInfoDto account,@PathVariable Long id){
        return ResponseEntity.ok(accountService.updateAccount(id,account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAccount(@PathVariable Long id){
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }

}
