package com.codeunlu.rentacar.dto.usercontact;

import com.codeunlu.rentacar.model.users.Individual;
import com.codeunlu.rentacar.model.enums.ContactType;

public class ContactDto {
    private Individual individuals;
    private ContactType contactTypeId;
    private String content;

    public Individual getIndividuals() {
        return individuals;
    }

    public void setIndividuals(Individual individuals) {
        this.individuals = individuals;
    }

    public ContactType getContactTypeId() {
        return contactTypeId;
    }

    public void setContactTypeId(ContactType contactTypeId) {
        this.contactTypeId = contactTypeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
