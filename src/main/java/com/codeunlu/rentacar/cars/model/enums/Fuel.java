package com.codeunlu.rentacar.cars.model.enums;

public enum Fuel {
    Petrol(1),
    Diesel(2),
    Hybrid(3);
    private final Integer id;

    private Fuel(Integer id) {
        this.id = id;
    }
}
