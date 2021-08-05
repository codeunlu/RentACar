package com.codeunlu.rentacar.cars.model.enums;

public enum CarCaseType {
    Sedan(1),
    Hatchback(2),
    Suv(3);
    private final Integer id;

    private CarCaseType(Integer id){this.id = id;}
}
