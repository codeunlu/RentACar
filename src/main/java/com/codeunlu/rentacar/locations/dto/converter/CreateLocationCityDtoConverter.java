package com.codeunlu.rentacar.locations.dto.converter;

import com.codeunlu.rentacar.locations.dto.LocationCityDto;
import com.codeunlu.rentacar.locations.dto.request.CreateLocationCityRequest;
import com.codeunlu.rentacar.locations.model.LocationCity;
import org.springframework.stereotype.Component;

@Component
public class CreateLocationCityDtoConverter {

    public CreateLocationCityRequest convert(LocationCity from) {
        return new CreateLocationCityRequest(
                from.getId(),
                from.getTitle()
        );
    }

    public LocationCityDto convertToCity(LocationCity from){
        return new LocationCityDto(
                from.getId(),
                from.getTitle()
        );
    }
}
