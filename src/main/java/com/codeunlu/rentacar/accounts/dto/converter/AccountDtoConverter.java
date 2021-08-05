package com.codeunlu.rentacar.accounts.dto.converter;

import com.codeunlu.rentacar.accounts.dto.AccountDto;
import com.codeunlu.rentacar.accounts.model.Account;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class AccountDtoConverter {

    private final AccountContactDtoConverter converter;

    public AccountDtoConverter(AccountContactDtoConverter converter) {
        this.converter = converter;
    }

    public AccountDto convert(Account from){
        return new AccountDto(
                from.getEmail(),
                from.getPassword(),
                from.getName(),
                from.getSurname(),
                from.getDateOfBirth(),
                from.getNationalId(),
                from.getContacts()
                        .stream()
                        .map(converter::convert)
                        .collect(Collectors.toSet()));
    }
}
