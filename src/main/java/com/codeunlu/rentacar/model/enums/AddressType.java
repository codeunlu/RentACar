package com.codeunlu.rentacar.model.enums;

public enum AddressType {
    Contact(1),
    Invoice(2);

    private final Integer id;

    private AddressType(Integer id) {
        this.id = id;
    }
}
