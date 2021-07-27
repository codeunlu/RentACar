package com.codeunlu.rentacar.controller.cars;

import com.codeunlu.rentacar.dto.cars.CarBrandDto;
import com.codeunlu.rentacar.dto.cars.create.CreateBrandDto;
import com.codeunlu.rentacar.service.cars.CarBrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cars/brands")
public class CarBrandController {

    private final CarBrandService carBrandService;

    public CarBrandController(CarBrandService carBrandService) {
        this.carBrandService = carBrandService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateBrandDto> createBrands(@RequestBody CreateBrandDto createBrandDto){
        return ResponseEntity.ok(carBrandService.createBrands(createBrandDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CarBrandDto>> getAllBrand(){
        return ResponseEntity.ok(carBrandService.getAllBrand());
    }


    @PutMapping("/{id}/edit")
    public ResponseEntity<CarBrandDto> updateBrand(@PathVariable Long id,
                                                   @RequestBody CarBrandDto carBrandDto){
        return ResponseEntity.ok(carBrandService.updateBrand(id,carBrandDto));
    }

}
