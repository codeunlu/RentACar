package com.codeunlu.rentacar.accounts.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateAccountInfoDto {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
}
