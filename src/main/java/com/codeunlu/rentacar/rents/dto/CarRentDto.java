package com.codeunlu.rentacar.rents.dto;


import com.codeunlu.rentacar.cars.dto.request.CreateCarRequest;
import com.codeunlu.rentacar.locations.dto.request.CreateLocationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRentDto {
    private Long id;
    private CreateLocationRequest location;
    private CreateCarRequest car;
    private LocalDate startDate;
    private LocalDate endDate;
}
