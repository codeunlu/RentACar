package com.codeunlu.rentacar.dto.users;

import java.util.Set;

public class CorporateDto {

    private String companyName;
    private String companyURI;
    private String companyContact;
    private Set<AddressDto> addresses;

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

    public Set<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressDto> addresses) {
        this.addresses = addresses;
    }
}
