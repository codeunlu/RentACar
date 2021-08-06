package com.codeunlu.rentacar.locations.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLocationCityRequest {
    private Long id;
    private String title;
}
