package com.codeunlu.rentacar.service.cars;

import com.codeunlu.rentacar.dto.cars.create.CreateCarDto;
import com.codeunlu.rentacar.model.cars.Car;
import com.codeunlu.rentacar.model.cars.CarBrand;
import com.codeunlu.rentacar.model.cars.CarModel;
import com.codeunlu.rentacar.repository.cars.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarBrandService carBrandService;
    private final CarModelService carModelService;
    private final ModelMapper modelMapper;

    public CarService(CarRepository carRepository, CarBrandService carBrandService, CarModelService carModelService, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.carBrandService = carBrandService;
        this.carModelService = carModelService;
        this.modelMapper = modelMapper;
    }

    public CreateCarDto createCars(CreateCarDto createCarDto) {
        CarBrand carBrand = carBrandService.findById(createCarDto.getCarBrand().getId());
        CarModel carModel = carModelService.findById(createCarDto.getCarModel().getId());
        Car car = modelMapper.map(createCarDto,Car.class);
        if(!carBrand.equals(null) && !carModel.equals(null)){
            return modelMapper.map(carRepository.save(car),CreateCarDto.class);
        }
        return null;
    }

}
