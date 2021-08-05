package com.codeunlu.rentacar.accounts.dto.converter;

import com.codeunlu.rentacar.accounts.dto.AccountContactDto;
import com.codeunlu.rentacar.accounts.model.Contact;
import org.springframework.stereotype.Component;

@Component
public class AccountContactDtoConverter {
    public AccountContactDto convert(Contact from){
        return new AccountContactDto(
                from.getId(),
                from.getContent(),
                from.getContactType()
        );
    }
}
