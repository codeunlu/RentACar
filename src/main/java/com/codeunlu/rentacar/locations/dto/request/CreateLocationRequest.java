package com.codeunlu.rentacar.locations.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLocationRequest {
    private String title;
    private CreateLocationCityRequest locationCity;
}
