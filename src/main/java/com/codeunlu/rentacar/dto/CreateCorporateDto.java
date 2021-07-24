package com.codeunlu.rentacar.dto;

import com.codeunlu.rentacar.model.Address;
import java.util.Set;

public class CreateCorporateDto {
    private String email;
    private String password;
    private String companyName;
    private String companyURI;
    private String companyContact;
    private Set<Address> addresses;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyURI() {
        return companyURI;
    }

    public void setCompanyURI(String companyURI) {
        this.companyURI = companyURI;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
