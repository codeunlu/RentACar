package com.codeunlu.rentacar.controller.cars;

import com.codeunlu.rentacar.dto.cars.CarModelDto;
import com.codeunlu.rentacar.dto.cars.create.CreateModelDto;
import com.codeunlu.rentacar.service.cars.CarModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars/models")
public class CarModelController {
    private final CarModelService carModelService;

    public CarModelController(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    @GetMapping("/brand/{id}/getAll")
    public ResponseEntity<List<CarModelDto>> getAllModelBrand(@PathVariable Long id){
        return ResponseEntity.ok(carModelService.getAllModelBrand(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarModelDto> getModel(@PathVariable Long id){
        return ResponseEntity.ok(carModelService.getModel(id));
    }

    @PostMapping("/brand/{id}/create")
    public ResponseEntity<CreateModelDto> createModels(@PathVariable Long id, @RequestBody CreateModelDto createModelDto){
        return ResponseEntity.ok(carModelService.createModels(id,createModelDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<CarModelDto> updateModel(@PathVariable Long id,
                                                   @RequestBody CarModelDto carModelDto){
        return ResponseEntity.ok(carModelService.updateModel(id,carModelDto));
    }
}
