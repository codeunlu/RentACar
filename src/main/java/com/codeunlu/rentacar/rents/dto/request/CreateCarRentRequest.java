package com.codeunlu.rentacar.rents.dto.request;

import com.codeunlu.rentacar.cars.dto.CarRentCarDto;
import com.codeunlu.rentacar.locations.dto.CarRentLocationDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRentRequest {
    private CarRentLocationDto location;
    private CarRentCarDto car;
    private LocalDate startDate;
    private LocalDate endDate;
}
