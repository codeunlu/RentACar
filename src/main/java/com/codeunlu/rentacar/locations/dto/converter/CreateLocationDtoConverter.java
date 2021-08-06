package com.codeunlu.rentacar.locations.dto.converter;

import com.codeunlu.rentacar.locations.dto.CarRentLocationDto;
import com.codeunlu.rentacar.locations.dto.LocationDto;
import com.codeunlu.rentacar.locations.dto.request.CreateLocationRequest;
import com.codeunlu.rentacar.locations.model.Location;
import org.springframework.stereotype.Component;

@Component
public class CreateLocationDtoConverter {

    private final CreateLocationCityDtoConverter converter;

    public CreateLocationDtoConverter(CreateLocationCityDtoConverter converter) {
        this.converter = converter;
    }

    public CreateLocationRequest converter(Location from){
        return new CreateLocationRequest(
                from.getTitle(),
                converter.convert(from.getLocationCity())
        );
    }

    public LocationDto convertToLocation(Location from){
        return new LocationDto(
                from.getId(),
                from.getTitle(),
                converter.convertToCity(from.getLocationCity())
        );
    }

    public CarRentLocationDto convertToCarRent(Location from){
        return new CarRentLocationDto(
                from.getId()
        );
    }
}
