package com.codeunlu.rentacar.cars.dto.converter;

import com.codeunlu.rentacar.cars.dto.CarRentCarDto;
import com.codeunlu.rentacar.cars.dto.request.CreateCarRequest;
import com.codeunlu.rentacar.cars.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CreateCarDtoConverter {

    private final CreateCarModelDtoConverter carModelConverter;

    public CreateCarDtoConverter(CreateCarModelDtoConverter carModelConverter) {
        this.carModelConverter = carModelConverter;
    }

    public CreateCarRequest convert(Car from){
        return new CreateCarRequest(
                from.getId(),
                from.getTitle(),
                from.getContent(),
                carModelConverter.convert(from.getCarModel()),
                from.getCarYear(),
                from.getFuel(),
                from.getGear(),
                from.getCarCaseType(),
                from.getCarDoor()
        );
    }

    public CarRentCarDto convertToCarRent(Car from){
        return new CarRentCarDto(
                from.getId()
        );
    }
}
