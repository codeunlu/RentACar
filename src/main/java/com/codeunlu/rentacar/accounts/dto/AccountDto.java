package com.codeunlu.rentacar.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private String email;

    private String password;

    private String name;

    private String surname;

    private LocalDate dateOfBirth;

    private String nationalId;

    private Set<AccountContactDto> contacts;
}
