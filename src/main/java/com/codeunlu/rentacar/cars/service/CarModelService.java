package com.codeunlu.rentacar.cars.service;

import com.codeunlu.rentacar.cars.dto.converter.CreateCarBrandDtoConverter;
import com.codeunlu.rentacar.cars.dto.converter.CreateCarModelDtoConverter;
import com.codeunlu.rentacar.cars.dto.request.CreateCarModelRequest;
import com.codeunlu.rentacar.cars.exception.CarModelNotFoundException;
import com.codeunlu.rentacar.cars.model.CarBrand;
import com.codeunlu.rentacar.cars.model.CarModel;
import com.codeunlu.rentacar.cars.repository.CarModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarModelService {
    private final CarModelRepository carModelRepository;
    private final CarBrandService carBrandService;
    private final CreateCarModelDtoConverter converter;
    private final CreateCarBrandDtoConverter carBrandConverter;

    public CarModelService(CarModelRepository carModelRepository, CarBrandService carBrandService,
                           CreateCarModelDtoConverter converter, CreateCarBrandDtoConverter carBrandConverter) {
        this.carModelRepository = carModelRepository;
        this.carBrandService = carBrandService;
        this.converter = converter;
        this.carBrandConverter = carBrandConverter;
    }

    public Boolean createModel(CreateCarModelRequest request){
        CarBrand carBrandControl = carBrandService.findById(request.getCarBrand().getId());
        if(findByName(request.getName()) != null && carBrandControl == null){
            return false;
        }
        CarModel carModel = new CarModel();
        carModel.setName(request.getName());
        carModel.setCarBrand(carBrandControl);
        converter.convert(carModelRepository.save(carModel));
        return true;

    }

    public CreateCarModelRequest updateModel(CreateCarModelRequest request,Long id){
        CarModel carModel = findById(id);
        if(carModel != null){
            CarBrand carBrand = carBrandService.findById(request.getCarBrand().getId());
            carModel.setName(request.getName());
            carModel.setCarBrand(carBrand);
            return converter.convert(carModelRepository.save(carModel));
        }
        return null;
    }

    public Boolean deleteModel(Long id){
        CarModel carModel = findById(id);
        if(carModel != null){
            carModelRepository.delete(carModel);
            return true;
        }
        return false;
    }

    public List<CreateCarModelRequest> getAll(){
        return carModelRepository.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public CreateCarModelRequest getModel(Long id){
        return converter.convert(findById(id));
    }

    protected CarModel findById(Long id){
        return carModelRepository.findById(id)
                .orElseThrow(() -> new CarModelNotFoundException("Car Model is not founded!"));
    }

    protected CarModel findByName(String name){
        return carModelRepository.findByName(name);
    }
}
