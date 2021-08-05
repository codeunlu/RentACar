package com.codeunlu.rentacar.cars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarModelNotFoundException extends RuntimeException{
    public CarModelNotFoundException(String message) {
        super(message);
    }
}
