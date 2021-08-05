package com.codeunlu.rentacar.cars.dto.converter;

import com.codeunlu.rentacar.cars.dto.request.CreateCarModelRequest;
import com.codeunlu.rentacar.cars.model.CarModel;
import org.springframework.stereotype.Component;

@Component
public class CreateCarModelDtoConverter {

    private final CreateCarBrandDtoConverter converter;

    public CreateCarModelDtoConverter(CreateCarBrandDtoConverter converter) {
        this.converter = converter;
    }

    public CreateCarModelRequest convert(CarModel from){
        return new CreateCarModelRequest(
                from.getId(),
                from.getName(),
                converter.convert(from.getCarBrand())
        );
    }
}
