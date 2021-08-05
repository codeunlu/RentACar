package com.codeunlu.rentacar.cars.controller;

import com.codeunlu.rentacar.cars.dto.request.CreateCarModelRequest;
import com.codeunlu.rentacar.cars.service.CarModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cars/models")
public class CarModelController {
    private final CarModelService carModelService;

    public CarModelController(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    @PostMapping
    public ResponseEntity<Boolean> createModel(@RequestBody CreateCarModelRequest request){
        return ResponseEntity.ok(carModelService.createModel(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreateCarModelRequest> updateModel(@RequestBody CreateCarModelRequest request,
                                                             @PathVariable Long id){
        return ResponseEntity.ok(carModelService.updateModel(request,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteModel(@PathVariable Long id){
        return ResponseEntity.ok(carModelService.deleteModel(id));
    }

    @GetMapping
    public ResponseEntity<List<CreateCarModelRequest>> getAll(){
        return ResponseEntity.ok(carModelService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateCarModelRequest> getModel(@PathVariable Long id){
        return ResponseEntity.ok(carModelService.getModel(id));
    }
}
