package com.codeunlu.rentacar.cars.dto;

import com.codeunlu.rentacar.cars.model.CarBrand;
import com.codeunlu.rentacar.cars.model.CarModel;
import com.codeunlu.rentacar.cars.model.enums.CarCaseType;
import com.codeunlu.rentacar.cars.model.enums.Fuel;
import com.codeunlu.rentacar.cars.model.enums.Gear;
import lombok.Data;

import javax.persistence.*;

@Data
public class CarDto {
    private Long id;
    private String title;
    private String content;
    private CarBrand carBrand;
    private CarModel carModel;
    private Long carYear;
    private Fuel fuel;
    private Gear gear;
    private CarCaseType carCaseType;
    private Long carDoor;
}
