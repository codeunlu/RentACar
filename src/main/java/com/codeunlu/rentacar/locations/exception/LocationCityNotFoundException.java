package com.codeunlu.rentacar.locations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocationCityNotFoundException extends RuntimeException{
    public LocationCityNotFoundException(String message) {
        super(message);
    }
}
