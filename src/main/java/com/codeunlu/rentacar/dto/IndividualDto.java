package com.codeunlu.rentacar.dto;

import com.codeunlu.rentacar.dto.usercontact.AddressDto;
import com.codeunlu.rentacar.dto.usercontact.ContactDto;

import java.time.LocalDate;
import java.util.Set;

public class IndividualDto {
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String nationalId;
    private Set<ContactDto> contacts;
    private Set<AddressDto> addresses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Set<ContactDto> getContacts() {
        return contacts;
    }

    public void setContacts(Set<ContactDto> contacts) {
        this.contacts = contacts;
    }

    public Set<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressDto> addresses) {
        this.addresses = addresses;
    }
}
