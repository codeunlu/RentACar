package com.codeunlu.rentacar.locations.service;

import com.codeunlu.rentacar.locations.dto.LocationCityDto;
import com.codeunlu.rentacar.locations.dto.converter.CreateLocationCityDtoConverter;
import com.codeunlu.rentacar.locations.dto.request.CreateLocationCityRequest;
import com.codeunlu.rentacar.locations.exception.LocationCityNotFoundException;
import com.codeunlu.rentacar.locations.model.LocationCity;
import com.codeunlu.rentacar.locations.repository.LocationCityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationCityService {

    private final LocationCityRepository locationCityRepository;
    private final CreateLocationCityDtoConverter converter;


    public LocationCityService(LocationCityRepository locationCityRepository, CreateLocationCityDtoConverter converter) {
        this.locationCityRepository = locationCityRepository;
        this.converter = converter;
    }


    public Boolean createCity(CreateLocationCityRequest request){
        if(findByTitle(request.getTitle()) != null){
            return false;
        }
        LocationCity city = new LocationCity();
        city.setTitle(request.getTitle());
        converter.convert(locationCityRepository.save(city));
        return true;
    }

    public Boolean deleteCity(Long id){
        LocationCity city = findById(id);
        locationCityRepository.delete(city);
        return true;
    }

    public LocationCityDto updateCity(CreateLocationCityRequest request, Long id) {
        LocationCity city = findById(id);
        city.setTitle(request.getTitle());
        return converter.convertToCity(locationCityRepository.save(city));
    }

    public List<LocationCityDto> getAll(){
        return locationCityRepository.findAll()
                .stream()
                .map(converter::convertToCity)
                .collect(Collectors.toList());
    }

    public LocationCityDto getCity(Long id){
        LocationCity city = findById(id);
        return converter.convertToCity(city);
    }

    protected LocationCity findByTitle(String title){
        return locationCityRepository.findByTitle(title);
    }

    protected LocationCity findById(Long id){
        return locationCityRepository.findById(id)
                .orElseThrow(() -> new LocationCityNotFoundException("City is not founded!"));
    }
}
