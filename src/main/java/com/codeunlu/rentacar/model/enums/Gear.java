package com.codeunlu.rentacar.model.enums;

public enum Gear {
    Automatic(1),
    Manual(2),
    SemiAutomatic(3);
    private final Integer id;

    private Gear(Integer id) {
        this.id = id;
    }
}
