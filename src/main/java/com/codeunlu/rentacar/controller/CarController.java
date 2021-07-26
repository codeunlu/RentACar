package com.codeunlu.rentacar.controller;

import com.codeunlu.rentacar.dto.create.CreateBrandDto;
import com.codeunlu.rentacar.dto.create.CreateCarDto;
import com.codeunlu.rentacar.dto.create.CreateModelDto;
import com.codeunlu.rentacar.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCarDto> createCars(@RequestBody CreateCarDto createCarDto){
        return ResponseEntity.ok(carService.createCars(createCarDto));
    }

    @PostMapping("/brand/create")
    public ResponseEntity<CreateBrandDto> createBrands(@RequestBody CreateBrandDto createBrandDto){
        return ResponseEntity.ok(carService.createBrands(createBrandDto));
    }
    @PostMapping("/brand/{id}/model/create")
    public ResponseEntity<CreateModelDto> createModels(@PathVariable Long id,@RequestBody CreateModelDto createModelDto){
        return ResponseEntity.ok(carService.createModels(id,createModelDto));
    }
}
