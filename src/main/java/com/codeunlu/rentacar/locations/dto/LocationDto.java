package com.codeunlu.rentacar.locations.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    private Long id;
    private String title;
    private LocationCityDto locationCity;
}
