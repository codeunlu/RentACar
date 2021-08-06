package com.codeunlu.rentacar.locations.controller;

import com.codeunlu.rentacar.locations.dto.LocationCityDto;
import com.codeunlu.rentacar.locations.dto.LocationDto;
import com.codeunlu.rentacar.locations.dto.request.CreateLocationCityRequest;
import com.codeunlu.rentacar.locations.dto.request.CreateLocationRequest;
import com.codeunlu.rentacar.locations.service.LocationCityService;
import com.codeunlu.rentacar.locations.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/locations")
public class LocationController {
    private final LocationService locationService;
    private final LocationCityService locationCityService;

    public LocationController(LocationService locationService, LocationCityService locationCityService) {
        this.locationService = locationService;
        this.locationCityService = locationCityService;
    }

    @PostMapping("/cities")
    public ResponseEntity<Boolean> createCity(@RequestBody CreateLocationCityRequest request){
        return ResponseEntity.ok(locationCityService.createCity(request));
    }
    @PutMapping("/cities/{id}")
    public ResponseEntity<LocationCityDto> updateCity(@RequestBody CreateLocationCityRequest request,
                                                      @PathVariable Long id){
        return ResponseEntity.ok(locationCityService.updateCity(request,id));
    }

    @DeleteMapping("/cities/{id}")
    public ResponseEntity<Boolean> deleteCity(@PathVariable Long id){
        return ResponseEntity.ok(locationCityService.deleteCity(id));
    }

    @GetMapping("/cities")
    public ResponseEntity<List<LocationCityDto>> getAllCity(){
        return ResponseEntity.ok(locationCityService.getAll());
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<LocationCityDto> getCity(@PathVariable Long id){
        return ResponseEntity.ok(locationCityService.getCity(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> createLocation(@RequestBody CreateLocationRequest request){
        return ResponseEntity.ok(locationService.createLocation(request));
    }

    @PutMapping
    public ResponseEntity<LocationDto> updateLocation(@RequestBody CreateLocationRequest request, @PathVariable Long id){
        return ResponseEntity.ok(locationService.updateLocation(request,id));
    }
    @DeleteMapping
    public ResponseEntity<Boolean> deleteLocation(@PathVariable Long id){
        return ResponseEntity.ok(locationService.deleteLocation(id));
    }
    @GetMapping
    public ResponseEntity<List<LocationDto>> getAllLocation(){
        return ResponseEntity.ok(locationService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<LocationDto> getLocation(@PathVariable Long id){
        return ResponseEntity.ok(locationService.getLocation(id));
    }

}
