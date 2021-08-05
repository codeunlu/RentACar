package com.codeunlu.rentacar.accounts.dto;

import com.codeunlu.rentacar.accounts.model.ContactType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountContactDto {
    private Long id;
    private String content;
    private ContactType contactType;
}
