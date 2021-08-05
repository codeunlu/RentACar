package com.codeunlu.rentacar.cars.dto.converter;

import com.codeunlu.rentacar.cars.dto.request.CreateCarBrandRequest;
import com.codeunlu.rentacar.cars.model.CarBrand;
import org.springframework.stereotype.Component;

@Component
public class CreateCarBrandDtoConverter {
    public CreateCarBrandRequest convert(CarBrand from){
        return new CreateCarBrandRequest(
                from.getId(),
                from.getName()
        );
    }
}
