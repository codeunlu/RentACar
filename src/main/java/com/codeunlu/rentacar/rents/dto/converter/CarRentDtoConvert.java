package com.codeunlu.rentacar.rents.dto.converter;

import com.codeunlu.rentacar.cars.dto.converter.CreateCarDtoConverter;
import com.codeunlu.rentacar.locations.dto.converter.CreateLocationDtoConverter;
import com.codeunlu.rentacar.rents.dto.CarRentDto;
import com.codeunlu.rentacar.rents.dto.request.CreateCarRentRequest;
import com.codeunlu.rentacar.rents.model.CarRent;
import org.springframework.stereotype.Component;

@Component
public class CarRentDtoConvert {

    private final CreateCarDtoConverter converterToCar;
    private final CreateLocationDtoConverter convertToLocation;

    public CarRentDtoConvert(CreateCarDtoConverter converterToCar, CreateLocationDtoConverter convertToLocation) {
        this.converterToCar = converterToCar;
        this.convertToLocation = convertToLocation;
    }

    public CreateCarRentRequest convert(CarRent from){
        return new CreateCarRentRequest(
                convertToLocation.convertToCarRent(from.getLocation()),
                converterToCar.convertToCarRent(from.getCar()),
                from.getStartDate(),
                from.getEndDate()
        );
    }

    public CarRentDto converToCarRent(CarRent from){
        return new CarRentDto(
                from.getId(),
                convertToLocation.converter(from.getLocation()),
                converterToCar.convert(from.getCar()),
                from.getStartDate(),
                from.getEndDate()
        );
    }


}
