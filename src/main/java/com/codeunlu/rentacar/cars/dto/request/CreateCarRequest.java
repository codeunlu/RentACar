package com.codeunlu.rentacar.cars.dto.request;

import com.codeunlu.rentacar.cars.model.CarBrand;
import com.codeunlu.rentacar.cars.model.CarModel;
import com.codeunlu.rentacar.cars.model.enums.CarCaseType;
import com.codeunlu.rentacar.cars.model.enums.Fuel;
import com.codeunlu.rentacar.cars.model.enums.Gear;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    private Long id;
    private String title;
    private String content;
    private CreateCarModelRequest carModel;
    private Long carYear;
    private Fuel fuel;
    private Gear gear;
    private CarCaseType carCaseType;
    private Long carDoor;
}
