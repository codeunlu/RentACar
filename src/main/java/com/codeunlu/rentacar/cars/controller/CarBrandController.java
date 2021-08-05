package com.codeunlu.rentacar.cars.controller;

import com.codeunlu.rentacar.cars.dto.request.CreateCarBrandRequest;
import com.codeunlu.rentacar.cars.service.CarBrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cars/brands")
public class CarBrandController {
    private final CarBrandService carBrandService;

    public CarBrandController(CarBrandService carBrandService) {
        this.carBrandService = carBrandService;
    }

    @PostMapping
    public ResponseEntity<Boolean> createCarBrand(@RequestBody CreateCarBrandRequest request){
        return ResponseEntity.ok(carBrandService.createCarBrand(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCarBrand(@PathVariable Long id){
        return ResponseEntity.ok(carBrandService.deleteCarBrand(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateCarBrandRequest> updateCarBrand(@RequestBody CreateCarBrandRequest request,
                                                                @PathVariable Long id){
        return ResponseEntity.ok(carBrandService.updateCarBrand(request,id));
    }

    @GetMapping
    public ResponseEntity<List<CreateCarBrandRequest>> getAll(){
        return ResponseEntity.ok(carBrandService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateCarBrandRequest> getCarBrand(@PathVariable Long id){
        return ResponseEntity.ok(carBrandService.getCarBrand(id));
    }

}
