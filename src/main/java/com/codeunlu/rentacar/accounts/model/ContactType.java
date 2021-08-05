package com.codeunlu.rentacar.accounts.model;

public enum ContactType {
    Home(1),
    Mobile(2);

    private final Integer id;

    private ContactType(Integer id) {
        this.id = id;
    }
}
