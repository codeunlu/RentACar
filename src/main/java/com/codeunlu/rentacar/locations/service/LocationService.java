package com.codeunlu.rentacar.locations.service;

import com.codeunlu.rentacar.locations.dto.LocationDto;
import com.codeunlu.rentacar.locations.dto.converter.CreateLocationDtoConverter;
import com.codeunlu.rentacar.locations.dto.request.CreateLocationRequest;
import com.codeunlu.rentacar.locations.exception.LocationNotFoundException;
import com.codeunlu.rentacar.locations.model.Location;
import com.codeunlu.rentacar.locations.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationCityService cityService;
    private final CreateLocationDtoConverter converter;

    public LocationService(LocationRepository locationRepository, LocationCityService cityService, CreateLocationDtoConverter converter) {
        this.locationRepository = locationRepository;
        this.cityService = cityService;
        this.converter = converter;
    }

    public Boolean createLocation(CreateLocationRequest request){
        if(findByTitle(request.getTitle()) != null){
            return false;
        }
        Location location = new Location();
        location.setTitle(request.getTitle());
        location.setLocationCity(cityService.findById(request.getLocationCity().getId()));
        converter.converter(locationRepository.save(location));
        return true;
    }

    public Boolean deleteLocation(Long id){
        Location location = findById(id);
        if(location != null){
            locationRepository.delete(location);
            return true;
        }
        return false;
    }

    public LocationDto updateLocation(CreateLocationRequest request, Long id){
        Location location = findById(id);
        location.setTitle(request.getTitle());
        location.setLocationCity(cityService.findById(request.getLocationCity().getId()));
        return converter.convertToLocation(locationRepository.save(location));
    }

    public List<LocationDto> getAll(){
        return locationRepository.findAll()
                .stream()
                .map(converter::convertToLocation)
                .collect(Collectors.toList());
    }

    public LocationDto getLocation(Long id){
        Location location = findById(id);
        return converter.convertToLocation(location);
    }


    protected Location findByTitle(String title){
        return locationRepository.findByTitle(title);
    }

    public Location findById(Long id){
        return locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Location is not founded!"));
    }

}
