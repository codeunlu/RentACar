package com.codeunlu.rentacar.controller.cars;

import com.codeunlu.rentacar.dto.cars.create.CreateCarDto;
import com.codeunlu.rentacar.service.cars.CarService;
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
}
