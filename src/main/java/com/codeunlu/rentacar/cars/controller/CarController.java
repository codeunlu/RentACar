package com.codeunlu.rentacar.cars.controller;

import com.codeunlu.rentacar.cars.dto.request.CreateCarRequest;
import com.codeunlu.rentacar.cars.dto.request.UpdateCarRequest;
import com.codeunlu.rentacar.cars.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Boolean> createCar(@RequestBody CreateCarRequest request){
        return ResponseEntity.ok(carService.createCar(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateCarRequest> updateCar(@RequestBody UpdateCarRequest request,@PathVariable Long id){
        return ResponseEntity.ok(carService.updateCar(request,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCar(@PathVariable Long id){
        return ResponseEntity.ok(carService.deleteCar(id));
    }

    @GetMapping
    public ResponseEntity<List<CreateCarRequest>> getAll(){
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateCarRequest> getCar(@PathVariable Long id){
        return ResponseEntity.ok(carService.getCar(id));
    }

}
