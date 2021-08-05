package com.codeunlu.rentacar.accounts.service;

import com.codeunlu.rentacar.accounts.dto.AccountDto;
import com.codeunlu.rentacar.accounts.dto.UpdateAccountInfoDto;
import com.codeunlu.rentacar.accounts.dto.converter.AccountDtoConverter;
import com.codeunlu.rentacar.accounts.exception.AccountNotFoundException;
import com.codeunlu.rentacar.accounts.model.Account;
import com.codeunlu.rentacar.accounts.model.Contact;
import com.codeunlu.rentacar.accounts.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountDtoConverter accountDtoConverter;

    public AccountService(AccountRepository accountRepository, AccountDtoConverter accountDtoConverter) {
        this.accountRepository = accountRepository;
        this.accountDtoConverter = accountDtoConverter;
    }

    public Boolean createAccount(AccountDto accountDto){
        if(findAccountByEmail(accountDto.getEmail()) != null){
            return false;
        }else{
            Account account = new Account();
            account.setEmail(accountDto.getEmail());
            account.setPassword(accountDto.getPassword());
            account.setName(accountDto.getName());
            account.setSurname(accountDto.getSurname());
            account.setDateOfBirth(accountDto.getDateOfBirth());
            account.setNationalId(accountDto.getNationalId());
            Contact contact = new Contact();
            accountDto.getContacts().forEach(c->{
                contact.setAccount(account);
                contact.setContent(c.getContent());
                contact.setContactType(c.getContactType());
            });
            Set<Contact> contacts = new HashSet<>();
            contacts.add(contact);
            account.setContacts(contacts);
            accountDtoConverter.convert(accountRepository.save(account));
            return true;
        }
    }

    public AccountDto updateAccount(Long id, UpdateAccountInfoDto accountDto){
        Account account = findAccountById(id);
        account.setName(accountDto.getName());
        account.setSurname(accountDto.getSurname());
        account.setDateOfBirth(accountDto.getDateOfBirth());
        return accountDtoConverter.convert(accountRepository.save(account));
    }

    public Boolean deleteAccount(Long id){
        accountRepository.delete(findAccountById(id));
        return true;
    }

    public List<AccountDto> getAllAccount(){
        return accountRepository.findAll()
                .stream()
                .map(accountDtoConverter::convert)
                .collect(Collectors.toList());
    }

    public AccountDto getAccount(Long id){
        return accountDtoConverter.convert(findAccountById(id));
    }

    protected Account findAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account is not found!"));
    }

    protected Account findAccountByEmail(String email){
        return accountRepository.findByEmail(email).orElseThrow(() -> new AccountNotFoundException("Account is not found"));
    }
}
