package com.codeunlu.rentacar.rents.controller;

import com.codeunlu.rentacar.rents.dto.CarRentDto;
import com.codeunlu.rentacar.rents.dto.request.CreateCarRentRequest;
import com.codeunlu.rentacar.rents.service.CarRentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/rents")
public class CarRentController {
    private final CarRentService carRentService;

    public CarRentController(CarRentService carRentService) {
        this.carRentService = carRentService;
    }

    @PostMapping
    public ResponseEntity<Boolean> createCarRent(@RequestBody CreateCarRentRequest request){
        return ResponseEntity.ok(carRentService.createCarRent(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateCarRentRequest> updateCarRent(@RequestBody CreateCarRentRequest request,
                                                              @PathVariable Long id){
        return ResponseEntity.ok(carRentService.updateCarRent(request,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCarRent(@PathVariable Long id){
        return ResponseEntity.ok(carRentService.deleteCarRent(id));
    }

    @GetMapping
    public ResponseEntity<List<CarRentDto>> getAll(){
        return ResponseEntity.ok(carRentService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarRentDto> getCarRent(@PathVariable Long id){
        return ResponseEntity.ok(carRentService.getCarRent(id));
    }
}
