package com.codeunlu.rentacar.cars.service;

import com.codeunlu.rentacar.cars.dto.converter.CreateCarBrandDtoConverter;
import com.codeunlu.rentacar.cars.dto.request.CreateCarBrandRequest;
import com.codeunlu.rentacar.cars.exception.CarBrandNotFoundException;
import com.codeunlu.rentacar.cars.model.CarBrand;
import com.codeunlu.rentacar.cars.repository.CarBrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarBrandService {
    private final CarBrandRepository carBrandRepository;
    private final CreateCarBrandDtoConverter converter;

    public CarBrandService(CarBrandRepository carBrandRepository, CreateCarBrandDtoConverter converter) {
        this.carBrandRepository = carBrandRepository;
        this.converter = converter;
    }

    public Boolean createCarBrand(CreateCarBrandRequest request){
        if(findByName(request.getName()) != null){
            return false;
        }else{
            CarBrand carBrand = new CarBrand();
            carBrand.setName(request.getName());
            converter.convert(carBrandRepository.save(carBrand));
            return true;
        }

    }

    public CreateCarBrandRequest updateCarBrand(CreateCarBrandRequest request, Long id){
        CarBrand carBrand = findById(id);
        carBrand.setName(request.getName());
        return converter.convert(carBrandRepository.save(carBrand));
    }

    public Boolean deleteCarBrand(Long id){
       carBrandRepository.delete(findById(id));
       return true;
    }

    public List<CreateCarBrandRequest> getAll(){
        return carBrandRepository.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public CreateCarBrandRequest getCarBrand(Long id){
        CarBrand carBrand = findById(id);
        return converter.convert(carBrand);
    }

    protected CarBrand findByName(String name){
        return carBrandRepository.findByName(name);
    }

    protected CarBrand findById(Long id){
        return carBrandRepository.findById(id).orElseThrow(()-> new CarBrandNotFoundException("Car is not founded!"));
    }
}
