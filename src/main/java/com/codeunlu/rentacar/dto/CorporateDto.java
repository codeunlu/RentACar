package com.codeunlu.rentacar.dto;

import com.codeunlu.rentacar.model.Address;
import com.codeunlu.rentacar.model.Contact;

import java.time.LocalDate;
import java.util.Set;

public class CorporateDto {

    private String companyName;
    private String companyURI;
    private String companyContact;
    private Set<Address> addresses;

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
