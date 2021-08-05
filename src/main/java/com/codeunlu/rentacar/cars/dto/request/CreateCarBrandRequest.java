package com.codeunlu.rentacar.cars.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarBrandRequest {
    private Long id;
    private String name;
}
